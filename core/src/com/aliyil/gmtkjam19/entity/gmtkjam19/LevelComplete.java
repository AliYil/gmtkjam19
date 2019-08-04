package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Text;

public class LevelComplete extends Text {
    private float counter = 1;
    public LevelComplete(Game game) {
        super(game, "Level Complete");
        setCentered(true);
        setScale(0.5f);
    }

    @Override
    public void tick() {
        setX(getSharedValues().cameraPos.x);
        setY(getSharedValues().cameraPos.y+300);

        counter-= dts();
        if(counter <= 0){
            kill();
            triggerNextLevel();
        }
        super.tick();
    }

    public void triggerNextLevel(){

    }
}
