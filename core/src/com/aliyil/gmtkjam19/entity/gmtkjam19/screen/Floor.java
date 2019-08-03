package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.gmtkjam19.TileBase;
import com.badlogic.gdx.graphics.Color;

public class Floor extends TileBase {
    public Floor(Game game) {
        super(game);
        setColor(new Color(0.45f, 0.45f, 0.45f, 1f));
        zIndex = -100;
    }
}
