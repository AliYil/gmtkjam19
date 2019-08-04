package com.aliyil.gmtkjam19;

import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;

public class PooledEntityEffect {
    ParticleEffectPool.PooledEffect effect;
    GameObject parentGameObject;
    boolean respectPause = false;
    public boolean draw = true;

    public PooledEntityEffect(ParticleEffectPool.PooledEffect effect) {
        this.effect = effect;
    }
}
