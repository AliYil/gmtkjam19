package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.gmtkjam19.AmmoPickup;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Enemy;

public class Level1 extends LevelBase {
    public Level1(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
        Enemy enemy1 = new Enemy(getGameInstance(), player);
        enemy1.setPosition(-300, 300);
        enemy1.start();
        screenEntitites.add(enemy1);
        Enemy enemy2 = new Enemy(getGameInstance(), player);
        enemy2.setPosition(-400, 300);
        enemy2.start();
        screenEntitites.add(enemy2);

        AmmoPickup ammo1 = new AmmoPickup(getGameInstance(), player);
        ammo1.setPosition(300, 300);
        ammo1.start();
        screenEntitites.add(ammo1);
    }

    @Override
    public boolean tileHasWall(int x, int y) {
        return super.tileHasWall(x, y);
    }

    @Override
    public boolean tileHasEnemy(int x, int y) {
        if(x == -300 && y == 300) return true;
        if(x == -400 && y == 300) return true;
        return super.tileHasEnemy(x, y);
    }

    @Override
    public boolean tileHasAmmo(int x, int y) {
        if(x == 300 && y == 300) return true;
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
}
