package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.math.Rectangle;

public class Wall extends GameObject implements Collideable {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    public Wall(Game game) {
        super(game);
    }

    @Override
    public boolean isStatic() {
        return true;
    }

    @Override
    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }
}
