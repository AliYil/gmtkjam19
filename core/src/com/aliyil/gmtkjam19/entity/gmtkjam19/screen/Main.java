package com.aliyil.gmtkjam19.entity.gmtkjam19.screen;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.entity.core.Screen;
import com.aliyil.gmtkjam19.entity.core.SpriteEntity;
import com.aliyil.gmtkjam19.entity.core.Text;
import com.badlogic.gdx.graphics.Color;

public class Main extends Screen {

    public Main(Game game) {
        super(game);
        enableInputListener(0);
    }

    @Override
    public void start() {
        getSharedValues().bgColor = Color.GRAY.cpy();
        SpriteEntity title = new SpriteEntity(getGameInstance(), getGameInstance().getResourceManager().logo);
        title.resizeWidth(1000);
        title.setPosition(0, 300);
        title.start();
        screenEntitites.add(title);

        String descStr = "W, A, S, D to move\nMouse to aim\nLeft mouse click to shoot\nYou have one ammo!\n\nClick to start!";
        Text desc = new Text(getGameInstance(), descStr);
        desc.setScale(0.4f);
        desc.setPosition(-400, 100);
        desc.start();
        screenEntitites.add(desc);

        Text desc2 = new Text(getGameInstance(), "Ver." + Game.ver);
        desc2.setScale(0.2f);
        desc2.setPosition(-400, -300);
        desc2.start();
        screenEntitites.add(desc2);

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
