package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Entity;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Collideable;
import com.aliyil.gmtkjam19.entity.gmtkjam19.Player;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

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
    }

    @Override
    public void tick() {
        super.tick();
        for (Entity entity1 : screenEntitites) {
            if(entity1 instanceof Collideable){
                Collideable collideable1 = (Collideable)entity1;
                for (Entity entity2 : screenEntitites) {
                    if(entity2 instanceof Collideable){
                        Collideable collideable2 = (Collideable)entity2;
                        if(Intersector.intersectRectangles(collideable1.getBoundingRectangle(), collideable2.getBoundingRectangle(), new Rectangle())){

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
