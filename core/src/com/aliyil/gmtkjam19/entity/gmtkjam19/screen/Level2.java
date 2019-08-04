package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level2 extends LevelBase {
    public Level2(Game game) {
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
        if(x == 2 && y == 2) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        return super.tileHasAmmo(x, y);
    }

    @Override
    public int getLevelWidth() {
        return 10;
    }

    @Override
    public int getLevelHeight() {
        return 10;
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    @Override
    public void triggerNextLevel() {

    }
}
