package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level2 extends LevelBase {
    public Level2(Game game) {
        super(game);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == 5 && y == 0) return true;
        if(x == 4 && y == 0) return true;
        if(x == 3 && y == 0) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == -5 && y == 0) return true;
        return super.tileHasAmmo(x, y);
    }

    @Override
    public int getSpawnX() {
        return -6;
    }

    @Override
    public int getSpawnY() {
        return 0;
    }

    @Override
    public int getLevelWidth() {
        return 15;
    }

    @Override
    public int getLevelHeight() {
        return 3;
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    @Override
    public void triggerNextLevel() {
        new Level3(getGameInstance()).start();
    }
}
