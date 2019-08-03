package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class AmmoPickup extends GameObject {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    private Player player;

    public AmmoPickup(Game game, Player player) {
        super(game);
        this.player = player;
        boundingRectangle = new Rectangle(0, 0, width, height);
        setColor(Color.CYAN);
    }

    @Override
    public void tick() {
        super.tick();
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);
        if(!player.hasAmmo()){
            if(Intersector.intersectRectangles(player.boundingRectangle, boundingRectangle, new Rectangle())){
                player.giveAmmo();
                kill();
            }
        }
    }

    public boolean touching(Vector2 pos){
        return Intersector.intersectSegmentRectangle(pos, pos, boundingRectangle);
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }
}
