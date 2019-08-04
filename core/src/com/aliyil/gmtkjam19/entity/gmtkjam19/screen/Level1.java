package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level1 extends LevelBase {
    public Level1(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == 11 && y == 0) return true;
        if(x == -11 && y == 0) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 3 && y == 0) return true;
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
        return 27;
    }

    @Override
    public int getLevelHeight() {
        return 10;
    }

    @Override
    public int getLevelNumber() {
        return 1;
    }

    @Override
    public void triggerNextLevel() {
        new Level2(getGameInstance()).start();
    }
}
