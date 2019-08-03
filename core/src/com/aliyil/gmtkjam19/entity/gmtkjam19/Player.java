package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    private static final float moveSpeed = 750;
    private static final float accelerationSpeed = 10000;

    private boolean ammo;
    public Player(Game game) {
        super(game);
        enableInputListener(0);
        enableMoving(true);
        boundingRectangle = new Rectangle(0, 0, width, height);
    }

    @Override
    public void start() {
        super.start();
        ammo = true;
    }

    @Override
    public void tick() {
        super.tick();
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);


        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean pressed = upPressed || rightPressed || downPressed || leftPressed;

        if(pressed){
            Vector2 moveAngle = new Vector2(1, 1);

            if(upPressed && !rightPressed && !downPressed && !leftPressed){
                moveAngle.setAngle(90);
            }
            else if(upPressed && rightPressed && !downPressed && !leftPressed){
                moveAngle.setAngle(45);
            }
            else if(!upPressed && rightPressed && !downPressed && !leftPressed){
                moveAngle.setAngle(0);
            }
            else if(!upPressed && rightPressed && downPressed && !leftPressed){
                moveAngle.setAngle(315);

            }
            else if(!upPressed && !rightPressed && downPressed && !leftPressed){
                moveAngle.setAngle(270);
            }
            else if(!upPressed && !rightPressed && downPressed && leftPressed){
                moveAngle.setAngle(225);
            }
            else if(!upPressed && !rightPressed && !downPressed && leftPressed){
                moveAngle.setAngle(180);
            }
            else if(upPressed && !rightPressed && !downPressed && leftPressed){
                moveAngle.setAngle(135);
            }else{
                moveAngle.set(0, 0);
            }
            acceleration.set(moveAngle.scl(accelerationSpeed));
        }else{
            if(speed.len() > 100f){
                acceleration.set(1, 1).scl(accelerationSpeed/2f).setAngle(speed.angle()-180);
            }else{
                speed.set(0, 0);
                acceleration.set(0, 0);
            }
        }
        speed.limit(moveSpeed);
//        if(leftPressed){
//            acceleration.x = -accelerationSpeed;
//        }
//
//        if(rightPressed){
//            acceleration.x = accelerationSpeed;
//        }
//        if(upPressed){
//            acceleration.y = -accelerationSpeed;
//        }
//
//        if(upPressed){
//            acceleration.y = accelerationSpeed;
//        }
//
//        if(speed.x >= moveSpeed && acceleration.x > 0){
//            acceleration.x = 0;
//            speed.x = moveSpeed;
//        }else if(speed.x <= -moveSpeed && acceleration.x < 0){
//            acceleration.x = 0;
//            speed.x = -moveSpeed;
//        }
//
//        if(!leftPressed && !rightPressed){
//            if(speed.x > 100f){
//                acceleration.x = -accelerationSpeed;
//            }else if(speed.x < -100f){
//                acceleration.x = accelerationSpeed;
//            }else{
//                speed.x = 0;
//                acceleration.x = 0;
//            }
//        }
    }

    @Override
    public void stop() {
        super.stop();
    }

//    @Override
//    public boolean keyDown(int keycode) {
//        if(keycode == Input.Keys.W){
//            speed.y = moveSpeed;
//        }
//        if(keycode == Input.Keys.S){
//            speed.y = -moveSpeed;
//        }
//        if(keycode == Input.Keys.A){
//            speed.x = -moveSpeed;
//        }
//        if(keycode == Input.Keys.D){
//            speed.x = moveSpeed;
//        }
//        return super.keyDown(keycode);
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        if(keycode == Input.Keys.W){
//            speed.y = 0;
//        }
//        if(keycode == Input.Keys.S){
//            speed.y = 0;
//        }
//        if(keycode == Input.Keys.A){
//            speed.x = 0;
//        }
//        if(keycode == Input.Keys.D){
//            speed.x = 0;
//        }
//        return super.keyUp(keycode);
//    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }
}
