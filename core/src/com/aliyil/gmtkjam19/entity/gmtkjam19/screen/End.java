package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;
import com.aliyil.gmtkjam19.entity.core.Text;
import com.badlogic.gdx.graphics.Color;

public class End extends Screen {

    public End(Game game) {
        super(game);
        enableInputListener(0);
    }

    @Override
    public void start() {
        getSharedValues().bgColor = Color.GRAY.cpy();
        String descStr = "Congratulations! You completed the game!\nThank you for playing!\n\nClick to restart";
        Text desc = new Text(getGameInstance(), descStr);
        desc.setScale(0.4f);
        desc.setPosition(0, 100);
        desc.setCentered(true);
        desc.start();
        screenEntitites.add(desc);

        super.start();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        new Main(getGameInstance()).start();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void stop() {
        super.stop();
    }


}
