package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Text;

public class LevelStartText extends Text {
    private float counter = 1;
    public LevelStartText(Game game, int level) {
        super(game, "Level " + level + " start!");
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
        }
        super.tick();
    }
}
