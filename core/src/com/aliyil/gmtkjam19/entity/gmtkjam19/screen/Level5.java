package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level5 extends LevelBase {
    public Level5(Game game) {
        super(game);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
//        if(x == -6 && y == -3) return true;
        if(x == -6 && y == -2) return true;
        if(x == -6 && y == -1) return true;
        if(x == -6 && y == 0) return true;
        if(x == -6 && y == 1) return true;
        if(x == -6 && y == 2) return true;
//        if(x == -6 && y == 3) return true;

//        if(x == 6 && y == -3) return true;
        if(x == 6 && y == -2) return true;
        if(x == 6 && y == -1) return true;
        if(x == 6 && y == 0) return true;
        if(x == 6 && y == 1) return true;
        if(x == 6 && y == 2) return true;
//        if(x == 6 && y == 3) return true;

//        if(x == -3 && y == -6) return true;
        if(x == -2 && y == -6) return true;
        if(x == -1 && y == -6) return true;
        if(x == 0 && y == -6) return true;
        if(x == 1 && y == -6) return true;
        if(x == 2 && y == -6) return true;
//        if(x == 3 && y == -6) return true;

//        if(x == -3 && y == 6) return true;
        if(x == -2 && y == 6) return true;
        if(x == -1 && y == 6) return true;
        if(x == 0 && y == 6) return true;
        if(x == 1 && y == 6) return true;
        if(x == 2 && y == 6) return true;
//        if(x == 3 && y == 6) return true;
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == -14 && y == 0) return true;
        if(x == -14 && y == -14) return true;
        if(x == -14 && y == 14) return true;
        if(x == 0 && y == -14) return true;
        if(x == 0 && y == 14) return true;
        if(x == 14 && y == 0) return true;
        if(x == 14 && y == -14) return true;
        if(x == 14 && y == 14) return true;
        if(x == 7 && y == 14) return true;
        if(x == -7 && y == 14) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 0 && y == 0) return true;
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
        return 30;
    }

    @Override
    public int getLevelHeight() {
        return 30;
    }

    @Override
    public int getLevelNumber() {
        return 5;
    }

    @Override
    public void triggerNextLevel() {
        new End(getGameInstance()).start();
    }
}
