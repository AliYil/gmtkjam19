package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Collideable;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Player;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class LevelBase extends Screen {
    protected Player player;
    public LevelBase(Game game) {
        super(game);
    }

    @Override
    public void start() {
        super.start();
        player = new Player(getGameInstance());
        player.start();
        screenEntitites.add(player);
    }

    @Override
    public void tick() {
        super.tick();
        for (Entity entity1 : screenEntitites) {
            if(entity1 instanceof Collideable){
                Collideable collideable1 = (Collideable)entity1;
//                if(collideable1.isStatic()) continue;
                for (Entity entity2 : screenEntitites) {
                    if(entity1 == entity2) continue;
                    if(entity2 instanceof Collideable){
                        Collideable collideable2 = (Collideable)entity2;
                        Rectangle intersection = new Rectangle();
                        if(Intersector.intersectRectangles(collideable1.getBoundingRectangle(), collideable2.getBoundingRectangle(), intersection)){
                             Vector2 sub = collideable1.getPosVector().cpy().sub(collideable2.getPosVector()).nor().scl(1f);
                             if(!collideable1.isStatic() && !collideable2.isStatic()){
                                 sub.scl(60f);
                             }else{
                                 sub.setAngle((int)((sub.angle()+45) / 90) * 90);
                             }
                             if(!collideable1.isStatic()){
                                 collideable1.getPosVector().add(sub);
                                 collideable1.getSpeedVector().set(0, 0);
                             }
                             if(!collideable2.isStatic()){
                                 collideable2.getPosVector().sub(sub);
                                 collideable2.getSpeedVector().set(0, 0);
                             }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        player.kill();
    }
}
