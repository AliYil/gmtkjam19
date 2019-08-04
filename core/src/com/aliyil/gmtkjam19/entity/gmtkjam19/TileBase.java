package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.aliyil.gmtkjam19.entity.gmtkjam19.screen.LevelBase;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class TileBase extends GameObject {
    protected Rectangle boundingRectangle;
    public TileBase(Game game) {
        super(game);
        boundingRectangle = new Rectangle(0, 0, LevelBase.tileSize, LevelBase.tileSize);
    }

    @Override
    public void tick() {
        super.tick();
        updateRectangle();
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }

    public void updateRectangle(){
        boundingRectangle.setPosition(getX() - LevelBase.tileSize/2f, getY() - LevelBase.tileSize/2f);
    }
}
