package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;
import com.badlogic.gdx.graphics.Color;

public class Crosshair extends SpriteEntity {
    public Crosshair(Game game) {
        super(game, game.getResourceManager().crosshair);
        resizeWidth(85);
        setColor(Color.RED);
    }

    @Override
    public void tick() {
        super.tick();
        setPosition(getSharedValues().touch);
    }
}
