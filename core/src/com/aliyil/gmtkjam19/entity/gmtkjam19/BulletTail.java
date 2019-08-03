package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class BulletTail extends GameObject {
    private Bullet bullet;
    public Vector2 start;
    public Vector2 end;

    public BulletTail(Game game, Bullet bullet) {
        super(game);
        this.bullet = bullet;
//            speed.set(bullet.speed);
        start = new Vector2();
        end = null;
        enableMoving(true);
    }

    @Override
    public void tick() {
        super.tick();
        if(end != null && start.cpy().sub(getPosVector()).len() > start.cpy().sub(end).len()){
            this.kill();
        }
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rectLine(getPosVector(), bullet.isLiving() ? bullet.getPosVector() : end, 5);
    }
}
