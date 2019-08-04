package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.Utilities;
import com.badlogic.gdx.graphics.Color;

public class Floor extends TileBase {
    public Floor(Game game) {
        super(game, game.getResourceManager().floor);
//        setColor(new Color(0.45f, 0.45f, 0.45f, 1f));
        zIndex = -100;

        if (Utilities.RANDOM.nextFloat() > 0.9f)
            getSprite().setTexture(game.getResourceManager().floor2);
    }
}
