package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Text;
import com.aliyil.gmtkjam19.entity.gmtkjam19.screen.Main;

public class YouDied extends Text {
    private float counter = 1;
    public YouDied(Game game) {
        super(game, "You Died!");
        setCentered(true);
        setScale(0.75f);
    }

    @Override
    public void tick() {
        setX(getSharedValues().cameraPos.x);
        setY(getSharedValues().cameraPos.y+300);

        counter-= dts();
        if(counter <= 0){
            kill();
            new Main(getGameInstance()).start();
        }
        super.tick();
    }
}
