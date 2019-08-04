package com.aliyil.gmtkjam19;

import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.Array;

public class ParticleEffectManager {

    private Array<PooledEntityEffect> effects;
    private Game gameInstance;

    private ParticleEffectPool growingCirclePool;
    private ParticleEffectPool zombieDamagePool;

    public ParticleEffectManager(Game gameInstance) {
        this.gameInstance = gameInstance;
    }

    public void renderAllParticles(Batch batch) {
        for (PooledEntityEffect entityEffect : effects) {
            if (entityEffect.parentGameObject != null) {
                if (!entityEffect.parentGameObject.isRunning()) {
                    entityEffect.effect.getEmitters().first().setContinuous(false);
                } else {
                    entityEffect.effect.setPosition(entityEffect.parentGameObject.getX(), entityEffect.parentGameObject.getY());
                }
            }

            if(entityEffect.draw)
                entityEffect.effect.draw(batch, entityEffect.respectPause ? gameInstance.sharedValues.paused ? 0 : S.dts(gameInstance.sharedValues.gameSpeed) : S.dts(gameInstance.sharedValues.gameSpeed));

            if (!entityEffect.effect.getEmitters().first().isContinuous() && entityEffect.effect.isComplete()) {
                effects.removeValue(entityEffect, true);
                entityEffect.effect.free();
            }
        }
    }

    public void loadResources() {
        effects = new Array<PooledEntityEffect>();

        ParticleEffect growingCircle = new ParticleEffect();
        growingCircle.load(Gdx.files.internal("particles/circles.p"), Gdx.files.internal("sprites"));
        growingCircle.start();
        growingCircle.scaleEffect(5f);
        growingCirclePool = new ParticleEffectPool(growingCircle, 10, 100);

        ParticleEffect zombieDamage = new ParticleEffect();
        zombieDamage.load(Gdx.files.internal("particles/zombiedamage.p"), Gdx.files.internal("sprites"));
        zombieDamage.start();
        zombieDamage.scaleEffect(1f);
        zombieDamagePool = new ParticleEffectPool(zombieDamage, 10, 100);
    }

    public void releaseResources() {
    }

    public int DBG_getTotalParticles() {
        int returnValue = 0;
        for (PooledEntityEffect entityEffect : effects) {
            for (ParticleEmitter emitter : entityEffect.effect.getEmitters()) {
                returnValue += emitter.getActiveCount();
            }
        }
        return returnValue;
    }

    //Should call setCountinuous(true) for all continuous particles
    public PooledEntityEffect newGrowingCircle(GameObject gameObject) {
        ParticleEffectPool.PooledEffect effect = growingCirclePool.obtain();
        effect.getEmitters().first().setContinuous(true);
        PooledEntityEffect peffect = new PooledEntityEffect(effect);
        peffect.parentGameObject = gameObject;
        peffect.respectPause = true;
        effects.add(peffect);
        return peffect;
    }

    public void newZombieDamage(float x, float y) {
        ParticleEffectPool.PooledEffect effect = zombieDamagePool.obtain();
        effect.setPosition(x, y);
        PooledEntityEffect peffect = new PooledEntityEffect(effect);
        effects.add(peffect);
    }
}
