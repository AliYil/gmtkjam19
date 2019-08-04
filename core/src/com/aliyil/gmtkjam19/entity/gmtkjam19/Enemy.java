package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.Utilities;
import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends GameObject implements Collideable {
    private Rectangle boundingRectangle;
    private static final int width = 100;
    private static final int height = 100;
    private static final float moveSpeed = 350;
    private Player player;

    private float behaviourTime;
    private Behaviour behaviour;
    private float wanderAngleTime;
    private float moveAngle= 0;
    public Enemy(Game game, Player player) {
        super(game);
        this.player = player;
        enableMoving(true);
        boundingRectangle = new Rectangle(0, 0, width, height);
        setColor(Color.BROWN);
//        zIndex = -1;
    }

    @Override
    public void start() {
        super.start();
        behaviourTime = 0;
        behaviour = Behaviour.Wander;
        wanderAngleTime = 0;
        speed.set(0, moveSpeed);
    }

    @Override
    public void tick() {
        super.tick();
        behaviourTime += dts();

        switch (behaviour){
            case Wander:
                wanderAngleTime += dts();
                if(wanderAngleTime >= 1f + Utilities.RANDOM.nextFloat()*1f){
                    wanderAngleTime = 0;
                    moveAngle = Utilities.RANDOM.nextFloat();
                }
                break;
            case Follow:
                moveAngle = player.getPosVector().cpy().sub(getPosVector()).angle();
                break;
        }
        moveAngle = (int)((moveAngle+27.5f) / 45) * 45;
        speed.set(0, moveSpeed);
        speed.setAngle(moveAngle);

        if(behaviourTime > 1f + Utilities.RANDOM.nextFloat()*1f){
//            switch (Utilities.RANDOM.nextInt(2)){
//                case 0:
//                    behaviour = Behaviour.Wander;
//                    break;
//                case 1:
//                    behaviour = Behaviour.Follow;
//                    break;
//            }
            if(Utilities.RANDOM.nextFloat() > 0.3f)
                behaviour = Behaviour.Follow;
            else
                behaviour = Behaviour.Wander;
            behaviourTime = 0;
        }
        updateRectangle();
    }

    public void updateRectangle(){
        boundingRectangle.setPosition(getX() - width/2f, getY() - height/2f);
    }

    @Override
    public void shapeRender(ShapeRenderer shapeRenderer) {
        super.shapeRender(shapeRenderer);
        shapeRenderer.rect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
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
        if(entity instanceof Wall){
            behaviour = Behaviour.Wander;
            moveAngle = Utilities.RANDOM.nextFloat() * 360;
        }
    }

    private enum Behaviour{
        Wander,
        Follow
    }
}
