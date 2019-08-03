package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public class Wall extends TileBase implements Collideable {
    public Wall(Game game) {
        super(game);
        setColor(Color.DARK_GRAY);
    }
    @Override
    public boolean isStatic() {
        return true;
    }

    @Override
    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    @Override
    public void onCollide(GameObject entity) {

    }
}
