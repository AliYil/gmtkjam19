package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends SpriteEntity implements Collideable {
    public Rectangle boundingRectangle;
    private static final int width = 50;
    private static final int height = 100;
    private static final float moveSpeed = 550;
    private static final float accelerationSpeed = 10000;

    private float health;

    private boolean ammo;
    private AmmoIndicator ammoIndicator;
    private Crosshair crosshair;
    public Player(Game game) {
        super(game, 0.15f, game.getResourceManager().albert.getRegions());
        enableInputListener(0);
//        zIndex = -1;
        enableMoving(true);
        boundingRectangle = new Rectangle(0, 0, width, height);
        resizeWidth(90);
        getSprite().setOrigin(getSprite().getOriginX(), getSprite().getOriginY()-30f);
    }

    @Override
    public void start() {
        super.start();
        ammo = true;
        health = 100f;
        ammoIndicator = new AmmoIndicator(getGameInstance());
        ammoIndicator.start();

        crosshair = new Crosshair(getGameInstance());
        crosshair.start();
    }

    @Override
    public void tick() {
        super.tick();
        updateRectangle();

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
                speed.set(0, 0);
            }
            acceleration.set(moveAngle.scl(accelerationSpeed));
            isAnimating = true;

            if(rightPressed)
                flipHorizontal = false;
            if(leftPressed)
                flipHorizontal = true;
        }else{
            if(speed.len() > 100f){
                acceleration.set(1, 1).scl(accelerationSpeed/2f).setAngle(speed.angle()-180);
            }else{
                speed.set(0, 0);
                acceleration.set(0, 0);
            }
            isAnimating = false;
            getSprite().setRegion(getAnimation().getKeyFrame(0.16f));
        }
        speed.limit(moveSpeed);

        if(ammo){
            crosshair.renderingEnabled = true;
            ammoIndicator.renderingEnabled = true;
            ammoIndicator.setPosition(getPosVector().cpy().add(0, 120));
        }else{
            crosshair.renderingEnabled = false;
            ammoIndicator.renderingEnabled = false;
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        if(ammo){
            float angle = getSharedValues().touch.cpy().sub(getPosVector()).angle();
            Bullet bullet = new Bullet(getGameInstance(), angle);
            bullet.setPosition(getPosVector().cpy().add(0, 30f));
            bullet.start();
            ammo = false;
            getGameInstance().getSoundManager().shotgun();
            new ScreenShake(getGameInstance()).start();
        }else{
            getGameInstance().getSoundManager().noAmmo();
        }
        return true;
    }

    @Override
    public void stop() {
        super.stop();
        ammoIndicator.kill();
        crosshair.kill();
    }

    public void giveAmmo(){
        ammo = true;
        getGameInstance().getSoundManager().reload();
    }

    public boolean hasAmmo(){
        return ammo;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    @Override
    public void onCollide(GameObject entity) {
        if(entity instanceof Enemy){
            updateHealth(-40);
        }
    }

    @Override
    public void updateRectangle() {
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);
    }

    private void updateHealth(int difference){
        health += difference;
        if(health <= 0){
            kill();
        }
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        if(health < 100){
            Vector2 healthBarPos = getPosVector().cpy().add(0, 150);
            Vector2 healthBarPosStart = healthBarPos.cpy().add(-75, 0);
            Vector2 healthBarPosEnd = healthBarPos.cpy().add(75, 0);

            shapeRenderer.setColor(new Color(0.5f, 0, 0, 0.5f));
            shapeRenderer.rectLine(healthBarPosStart, healthBarPosEnd, 20);

            shapeRenderer.setColor(new Color(0.9f, 0.3f, 0.3f, 1f));
            shapeRenderer.rectLine(healthBarPosStart, healthBarPosStart.cpy().lerp(healthBarPosEnd, health/100f), 20);
        }

        super.shapeRender(shapeRenderer);
    }
}
