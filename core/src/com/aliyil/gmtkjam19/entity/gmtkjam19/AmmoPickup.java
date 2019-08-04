package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.PooledEntityEffect;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class AmmoPickup extends SpriteEntity {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    private Player player;

    private float cooldown;
    private PooledEntityEffect particleEffect = null;

    public AmmoPickup(Game game, Player player) {
        super(game, game.getResourceManager().ammo);
        this.player = player;
        boundingRectangle = new Rectangle(0, 0, width, height);
        resizeWidth(30);
    }

    @Override
    public void start() {
        super.start();
        cooldown = 0;
        particleEffect = getGameInstance().getParticleEffectManager().newGrowingCircle(this);
    }

    @Override
    public void tick() {
        super.tick();
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);
        if(cooldown > 0){
            cooldown -= dts();
            setAlpha(0.4f);
            particleEffect.draw = false;
        }else{
            setAlpha(1);
            particleEffect.draw = true;
        }
        if(!player.hasAmmo() && cooldown <= 0){
            if(Intersector.intersectRectangles(player.boundingRectangle, boundingRectangle, new Rectangle())){
                player.giveAmmo();
                cooldown = 10;
//                kill();
            }
        }
    }

    public boolean touching(Vector2 pos){
        return Intersector.intersectSegmentRectangle(pos, pos, boundingRectangle);
    }
}
