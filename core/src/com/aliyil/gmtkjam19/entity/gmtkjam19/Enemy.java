package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends GameObject {
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
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }
}
