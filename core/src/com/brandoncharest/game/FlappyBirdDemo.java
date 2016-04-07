package com.brandoncharest.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brandoncharest.game.states.GameStateManager;
import com.brandoncharest.game.states.MenuState;

public class FlappyBirdDemo extends ApplicationAdapter {
	/*Sets game screen width and height*/
	public static final int WIDTH = 480;
	public static final int HEIGHT=800;

	public static final String TITLE="Flappy Bird";
	private GameStateManager gsm;
	private SpriteBatch batch;

	private Music musicPlayer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		musicPlayer = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		musicPlayer.setLooping(true);
		/*1 is 100% volume. .1 is 10%*/
		musicPlayer.setVolume(0.1f);
		musicPlayer.play();
		/*glClear?, I believe it wipes screen fresh.*/
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		musicPlayer.dispose();
	}
}
