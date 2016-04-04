package com.brandoncharest.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brandoncharest.game.FlappyBirdDemo;

/**
 * Created by Brandon on 4/2/2016.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, FlappyBirdDemo.WIDTH, FlappyBirdDemo.HEIGHT);
        sb.draw(playBtn, (FlappyBirdDemo.WIDTH / 2) - (playBtn.getWidth() / 2), FlappyBirdDemo.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
