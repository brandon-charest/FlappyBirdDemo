package com.brandoncharest.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Brandon on 4/7/2016.
 */
public class GameOverState extends PlayState {
    private Texture background;
    private Texture gameOver;




    public GameOverState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
    }
    @Override
    public void update(float dt) {
        handleInput();
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    public void render(SpriteBatch sb){
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(gameOver, (camera.position.x +25) - (camera.viewportWidth / 2), 200);
        sb.end();
    }

    public void dispose(){
        gameOver.dispose();
        System.out.println("GameOver State Disposed");
    }
}
