package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Player;

public abstract class LevelBase extends Screen {
    protected Player player;
    public LevelBase(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
        player = new Player(getGameInstance());
        player.start();
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void stop() {
        super.stop();
        player.kill();
    }
}
