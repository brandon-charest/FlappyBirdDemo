package com.brandoncharest.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brandoncharest.game.FlappyBirdDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=FlappyBirdDemo.WIDTH;
		config.height=FlappyBirdDemo.HEIGHT;
		config.title=FlappyBirdDemo.TITLE;
		new LwjglApplication(new FlappyBirdDemo(), config);
	}
}
