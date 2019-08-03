package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.gmtkjam19.AmmoPickup;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Enemy;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Wall;

public class Level1 extends LevelBase {
    public Level1(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
        Enemy enemy1 = new Enemy(getGameInstance());
        enemy1.setPosition(-300, 300);
        enemy1.start();
        screenEntitites.add(enemy1);

        AmmoPickup ammo1 = new AmmoPickup(getGameInstance(), player);
        ammo1.setPosition(300, 300);
        ammo1.start();
        screenEntitites.add(ammo1);

        Wall wall1 = new Wall(getGameInstance());
        wall1.setPosition(300, -300);
        wall1.start();
        screenEntitites.add(wall1);
    }
}
