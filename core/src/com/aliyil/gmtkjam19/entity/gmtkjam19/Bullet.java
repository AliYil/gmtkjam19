package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject {
    private static final float travelSpeed = 8000;
    BulletTail tail;
    public Bullet(Game game, float angle) {
        super(game);
        enableMoving(true);
        speed.set(1, 1).scl(travelSpeed).setAngle(angle);
        tail = new BulletTail(getGameInstance(), this);
    }

    @Override
    public void start() {
        super.start();
        tail.start.set(getPosVector());
        tail.getPosVector().set(getPosVector());
        tail.start();
    }

    @Override
    public void tick() {
        super.tick();
        if(getPosVector().len() > 10000) kill();
        if(tail.getPosVector().cpy().sub(getPosVector()).len() > 1000)
            tail.speed.set(speed);


        for (Entity entity : getGameInstance().getEntities()) {
            if(entity instanceof Enemy){
                Enemy enemy = (Enemy)entity;
                if(Intersector.intersectSegmentRectangle(getPosVector(), getTail(), enemy.getBoundingRectangle())){
                    enemy.kill();
                }
            }else if(entity instanceof Wall){
                Wall wall = (Wall)entity;
                if(Intersector.intersectSegmentRectangle(getPosVector(), getTail(), wall.getBoundingRectangle())){
                    kill();
                }
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        tail.end = getPosVector().cpy();
        tail.speed.set(speed);
    }

    public Vector2 getTail(){
//        return getPosVector().cpy().sub(speed.cpy().nor().scl(-1000f));
        return tail.getPosVector();
    }

}
