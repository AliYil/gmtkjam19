package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.S;
import com.aliyil.gmtkjam19.Utilities;
import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.gmtkjam19.AmmoPickup;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Collideable;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Crosshair;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Enemy;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Floor;
import com.aliyil.gmtkjam19.entity.gmtkjam19.LevelComplete;
import com.aliyil.gmtkjam19.entity.gmtkjam19.LevelStartText;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Player;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Wall;
import com.aliyil.gmtkjam19.entity.gmtkjam19.YouDied;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class LevelBase extends Screen {
    public static final int tileSize = 100;
    protected Player player;

    LevelStartText levelStartText;
    private boolean completed;

    public LevelBase(Game game) {
        super(game);
        zIndex = 10;
    }

    @Override
    public void start() {
        super.start();
        getSharedValues().bgColor =
                new Color(0.47f, 0.85f, 1f, 1f);
        completed = false;
        player = new Player(getGameInstance());
        player.setPosition(toWorldPos(getSpawnX(), getSpawnY()));
        player.start();
        screenEntitites.add(player);

        levelStartText = new LevelStartText(getGameInstance(), getLevelNumber());
        levelStartText.start();

        for (int x = (getLevelWidth() / 2) * -1; x <= getLevelWidth() / 2; x++) {
            for (int y = (getLevelHeight() / 2) * -1; y <= getLevelHeight() / 2; y++) {
                if (tileHasWall(x, y)) {
                    Wall wall = new Wall(getGameInstance());
                    wall.setPosition(toWorldPos(x, y));
                    wall.start();
                    screenEntitites.add(wall);
                } else {
                    Floor floor = new Floor(getGameInstance());
                    floor.setPosition(toWorldPos(x, y));
                    floor.start();
                    screenEntitites.add(floor);

//                    if (Utilities.RANDOM.nextFloat() > 0.9f)
//                        floor.setColor(new Color(0.35f, 0.35f, 0.35f, 1f));
                }

                if (tileHasEnemy(x, y)) {
                    Enemy enemy = new Enemy(getGameInstance(), player);
                    enemy.setPosition(toWorldPos(x, y));
                    enemy.start();
                    screenEntitites.add(enemy);
                }

                if (tileHasAmmo(x, y)) {
                    AmmoPickup ammo = new AmmoPickup(getGameInstance(), player);
                    ammo.setPosition(toWorldPos(x, y));
                    ammo.start();
                    screenEntitites.add(ammo);
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        for (Entity entity1 : getGameInstance().getEntities()) {
            if (entity1 instanceof Collideable) {
                Collideable collideable1 = (Collideable) entity1;
                for (Entity entity2 : getGameInstance().getEntities()) {
                    if (entity1 == entity2) continue;
                    if (entity2 instanceof Collideable) {
                        Collideable collideable2 = (Collideable) entity2;
                        Rectangle intersection = new Rectangle();
                        collideable1.updateRectangle();
                        collideable2.updateRectangle();
                        if (Intersector.intersectRectangles(Utilities.enlargeRectangle(collideable1.getBoundingRectangle(), -1), Utilities.enlargeRectangle(collideable2.getBoundingRectangle(), -1), intersection)) {
                            Vector2 sub = collideable1.getPosVector().cpy().sub(collideable2.getPosVector()).nor().scl(3f);
                            int subDirection = (int) ((sub.angle() + 45) / 90);
                            if (!collideable1.isStatic() && !collideable2.isStatic() && !(collideable1 instanceof Enemy && collideable2 instanceof Enemy)) {
                                sub.scl(20f);
                            } else {
                                sub.setAngle(subDirection * 90);
                                sub.scl(3f);
                            }
                            if (!collideable1.isStatic()) {
                                collideable1.getPosVector().add(sub);
                                if (subDirection == 0 || subDirection == 2) {
                                } else {
                                }
                            }
                            if (!collideable2.isStatic()) {
                                collideable2.getPosVector().sub(sub);
                                if (subDirection == 0 || subDirection == 2) {
                                    collideable1.getSpeedVector().scl(0, 1);
                                } else {
                                    collideable1.getSpeedVector().scl(1, 0);
                                }
                            }

                            collideable1.onCollide((GameObject) collideable2);
                            collideable2.onCollide((GameObject) collideable1);
                        }
                    }
                }
            }
        }

        if (!completed) {
            int enemyNumberCounter = 0;
            for (Entity entity : screenEntitites) {
                if (entity instanceof Enemy && entity.isLiving()) {
                    enemyNumberCounter++;
                }
            }

            if (enemyNumberCounter <= 0) {
                completed = true;
                LevelComplete levelComplete = new LevelComplete(getGameInstance()) {
                    @Override
                    public void triggerNextLevel() {
                        LevelBase.this.triggerNextLevel();
                    }
                };
                levelComplete.start();
            }

            if(!player.isLiving()){
                completed = true;
                new YouDied(getGameInstance()).start();
            }
        }

        //camera
        getSharedValues().cameraPos.lerp(player.getPosVector(), 5f * S.d());
    }

    private Vector2 toWorldPos(int x, int y) {
        return new Vector2(x * tileSize, y * tileSize);
    }

    public boolean tileHasWall(int x, int y) {
        if (x == (getLevelWidth() / 2) * -1) return true;
        if (x == getLevelWidth() / 2) return true;
        if (y == (getLevelHeight() / 2) * -1) return true;
        if (y == getLevelHeight() / 2) return true;
        return false;
    }

    public boolean tileHasEnemy(int x, int y) {
        return false;
    }

    public boolean tileHasAmmo(int x, int y) {
        return false;
    }

    public abstract int getSpawnX();
    public abstract int getSpawnY();

    public abstract int getLevelWidth();

    public abstract int getLevelHeight();

    public abstract int getLevelNumber();

    public abstract void triggerNextLevel();

    @Override
    public void stop() {
        super.stop();
        player.kill();
    }
}
