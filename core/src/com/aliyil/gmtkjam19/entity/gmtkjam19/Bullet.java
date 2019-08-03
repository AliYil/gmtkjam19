package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject {
    private static final float travelSpeed = 8000;
    private Tail tail;
    public Bullet(Game game, float angle) {
        super(game);
        enableMoving(true);
        speed.set(1, 1).scl(travelSpeed).setAngle(angle);
        tail = new Tail(getGameInstance(), this);
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
    }

    @Override
    public void stop() {
        super.stop();
        tail.end.set(getPosVector());
        tail.speed.set(speed);
    }

    private Vector2 getTail(){
//        return getPosVector().cpy().sub(speed.cpy().nor().scl(-1000f));
        return tail.getPosVector();
    }


    private class Tail extends GameObject{
        private Bullet bullet;
        public Vector2 start;
        public Vector2 end;

        public Tail(Game game, Bullet bullet) {
            super(game);
            this.bullet = bullet;
//            speed.set(bullet.speed);
            start = new Vector2();
            end = new Vector2();
            enableMoving(true);
        }

        @Override
        public void tick() {
            super.tick();
            if(start.cpy().sub(getPosVector()).len() > start.cpy().sub(end).len()){
                kill();
            }
        }

        @Override
        public void shapeRender(ShapeRenderer shapeRenderer) {
            super.shapeRender(shapeRenderer);
            shapeRenderer.rectLine(getPosVector(), bullet.getPosVector(), 5);
        }
    }
}
