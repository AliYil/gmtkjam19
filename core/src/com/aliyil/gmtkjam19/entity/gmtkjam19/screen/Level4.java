package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level4 extends LevelBase {
    public Level4(Game game) {
        super(game);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        if(x == 2 && y == -6) return true;
        if(x == 1 && y == -6) return true;
        if(x == 0 && y == -6) return true;
        if(x == -1 && y == -6) return true;
        if(x == -2 && y == -6) return true;
        if(x == -3 && y == -6) return true;

        if(x == 3 && y == -4) return true;
        if(x == 2 && y == -4) return true;
        if(x == 1 && y == -4) return true;
        if(x == 0 && y == -4) return true;
        if(x == -1 && y == -4) return true;
        if(x == -2 && y == -4) return true;

        if(x == 2 && y == 2) return true;
        if(x == 1 && y == 2) return true;
        if(x == 0 && y == 2) return true;
        if(x == -1 && y == 2) return true;
        if(x == -2 && y == 2) return true;
        if(x == -3 && y == 2) return true;

        if(x == 3 && y == 4) return true;
        if(x == 2 && y == 4) return true;
        if(x == 1 && y == 4) return true;
        if(x == 0 && y == 4) return true;
        if(x == -1 && y == 4) return true;
        if(x == -2 && y == 4) return true;
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == 0 && y == -5) return true;
        if(x == 0 && y == 3) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 0 && y == 7) return true;
        return super.tileHasAmmo(x, y);
    }

    @Override
    public int getSpawnX() {
        return 0;
    }

    @Override
    public int getSpawnY() {
        return -14;
    }

    @Override
    public int getLevelWidth() {
        return 8;
    }

    @Override
    public int getLevelHeight() {
        return 30;
    }

    @Override
    public int getLevelNumber() {
        return 4;
    }

    @Override
    public void triggerNextLevel() {
        new Level5(getGameInstance()).start();
    }
}
