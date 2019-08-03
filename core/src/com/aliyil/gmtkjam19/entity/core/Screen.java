package com.aliyil.gmtkjam19.entity.core;

import com.aliyil.gmtkjam19.Game;

import java.util.ArrayList;

public abstract class Screen extends Entity {
    protected ArrayList<Entity> screenEntitites;

    public Screen(Game game) {
        super(game);
        screenEntitites = new ArrayList<Entity>(10);
    }

    @Override
    public void start() {
        super.start();
        if (getGameInstance().getCurrentScreen() != null && getGameInstance().getCurrentScreen().isLiving() && getGameInstance().getCurrentScreen() != this)
            getGameInstance().getCurrentScreen().kill();
        getGameInstance().setCurrentScreen(this);
    }

    @Override
    public void stop() {
        for (Entity screenEntity : screenEntitites) {
            screenEntity.kill();
        }
        super.stop();
    }

    public boolean onBackPressed() {
        return false;
    }
}
