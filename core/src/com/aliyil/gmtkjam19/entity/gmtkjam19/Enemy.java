package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends GameObject implements Collideable {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    private static final float moveSpeed = 750;
    public Enemy(Game game) {
        super(game);
        enableMoving(true);
        boundingRectangle = new Rectangle(0, 0, width, height);
        setColor(Color.BROWN);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void tick() {
        super.tick();
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);

        for (Entity entity : getGameInstance().getEntities()) {
            if(entity instanceof Bullet){
                Bullet bullet = (Bullet)entity;
                if(Intersector.intersectSegmentRectangle(bullet.getPosVector(), bullet.getTail(), boundingRectangle)){
                    kill();
                }
            }
        }
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }
}
