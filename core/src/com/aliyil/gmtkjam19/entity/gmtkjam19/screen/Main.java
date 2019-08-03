package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.core.Text;

public class Main extends Screen {

    public Main(Game game) {
        super(game);
        enableInputListener(0);
    }

    @Override
    public void start() {
        Text title = new Text(getGameInstance(), "RUN OR GUN");
        title.setCentered(true);
        title.setPosition(0, 300);
        title.start();
        screenEntitites.add(title);

        String descStr = "W, A, S, D to move\nMouse to aim\nLeft mouse click to shoot\nYou have one ammo!\n\nClick to start!";
        Text desc = new Text(getGameInstance(), descStr);
        desc.setScale(0.4f);
        desc.setPosition(-400, 100);
        desc.start();
        screenEntitites.add(desc);

        super.start();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        new Level1(getGameInstance()).start();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void stop() {
        super.stop();
    }


}
