package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bullet extends GameObject {
    private static final float travelSpeed = 8000;
    public Bullet(Game game, float angle) {
        super(game);
        enableMoving(true);
        speed.set(1, 1).scl(travelSpeed).setAngle(angle);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void tick() {
        super.tick();
        if(getPosVector().len() > 10000) kill();
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rectLine(getPosVector(), getPosVector().cpy().sub(speed.cpy().scl(-0.05f)), 10);
    }
}
