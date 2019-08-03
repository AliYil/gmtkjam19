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
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        if(ammo){
            float angle = getSharedValues().touch.cpy().sub(getPosVector()).angle();
            Bullet bullet = new Bullet(getGameInstance(), angle);
            bullet.setPosition(getPosVector().cpy());
            bullet.start();
        }
        return true;
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
    }
}
