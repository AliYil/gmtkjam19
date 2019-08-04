package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;

public class Level1 extends LevelBase {
    public Level1(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
//        Enemy enemy1 = new Enemy(getGameInstance(), player);
//        enemy1.setPosition(-300, 300);
//        enemy1.start();
//        screenEntitites.add(enemy1);
//        Enemy enemy2 = new Enemy(getGameInstance(), player);
//        enemy2.setPosition(-400, 300);
//        enemy2.start();
//        screenEntitites.add(enemy2);
//
//        AmmoPickup ammo1 = new AmmoPickup(getGameInstance(), player);
//        ammo1.setPosition(300, 300);
//        ammo1.start();
//        screenEntitites.add(ammo1);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == -3 && y == 3) return true;
        if(x == -4 && y == 3) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 3 && y == 3) return true;
        return super.tileHasAmmo(x, y);
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
        return 1;
    }

    @Override
    public void triggerNextLevel() {
        new Level2(getGameInstance()).start();
    }
}
