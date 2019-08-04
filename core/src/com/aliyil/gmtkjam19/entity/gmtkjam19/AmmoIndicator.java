package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;

public class AmmoIndicator extends SpriteEntity {
    public AmmoIndicator(Game game) {
        super(game, game.getResourceManager().ammo);
        aspectRatio = 1f/aspectRatio;
        resizeWidth(50);
        getSprite().rotate90(true);
    }
}
