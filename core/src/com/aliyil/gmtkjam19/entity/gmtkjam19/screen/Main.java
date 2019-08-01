package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.core.Text;

public class Main extends Screen {

    public Main(Game game) {
        super(game);
    }

    @Override
    public void start() {
        new Text(getGameInstance(), "TEST").start();
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
