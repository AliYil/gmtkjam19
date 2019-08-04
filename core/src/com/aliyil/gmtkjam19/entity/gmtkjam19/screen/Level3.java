package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level3 extends LevelBase {
    public Level3(Game game) {
        super(game);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        if(x == -6 && y == -2) return true;
        if(x == -6 && y == -1) return true;
        if(x == -6 && y == 0) return true;
        if(x == -6 && y == 1) return true;
        if(x == -6 && y == 2) return true;

        if(x == 6 && y == -2) return true;
        if(x == 6 && y == -1) return true;
        if(x == 6 && y == 0) return true;
        if(x == 6 && y == 1) return true;
        if(x == 6 && y == 2) return true;

        if(x == 1 && y == -8) return true;
        if(x == -1 && y == -8) return true;
        if(x == 0 && y == -7) return true;

        if(x == 1 && y == 8) return true;
        if(x == -1 && y == 8) return true;
        if(x == 0 && y == 7) return true;
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == -8 && y == 0) return true;
        if(x == 8 && y == 0) return true;
        if(x == 0 && y == -8) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 0 && y == -8) return true;
        if(x == 0 && y == 8) return true;
        return super.tileHasAmmo(x, y);
    }

    @Override
    public int getSpawnX() {
        return 0;
    }

    @Override
    public int getSpawnY() {
        return 0;
    }

    @Override
    public int getLevelWidth() {
        return 20;
    }

    @Override
    public int getLevelHeight() {
        return 20;
    }

    @Override
    public int getLevelNumber() {
        return 3;
    }

    @Override
    public void triggerNextLevel() {
        new Level4(getGameInstance()).start();
    }
}
