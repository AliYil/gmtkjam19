package com.aliyil.gmtkjam19.desktop;

import com.aliyil.gmtkjam19.OsBridge;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.aliyil.gmtkjam19.Game;

public class DesktopLauncher implements OsBridge {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 480;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		config.vSyncEnabled = true;
		config.samples = 8;
		new LwjglApplication(new Game(new DesktopLauncher()), config);
	}
}
