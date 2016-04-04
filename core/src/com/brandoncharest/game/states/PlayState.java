package com.brandoncharest.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.brandoncharest.game.FlappyBirdDemo;
import com.brandoncharest.game.sprites.Bird;
import com.brandoncharest.game.sprites.Tube;

import java.util.Arrays;

/**
 * Created by Brandon on 4/4/2016.
 */
public class PlayState extends State {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture background;
    private Tube tube;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        bird = new Bird(50, 300);
        camera.setToOrtho(false, FlappyBirdDemo.WIDTH / 2, FlappyBirdDemo.HEIGHT / 2);

        tubes = new Array<Tube>();
        for(int i = 1; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }

    }

    @Override
    protected void handleInput() {
        /*Gdx handles input with mouse click, action makes bird jump.*/
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        camera.position.x = bird.getPosition().x +80;

        for(Tube tube: tubes){
            if(camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x +tube.getTopTube().getWidth()){
                tube.Reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }
            /*if player hits a tube game restarts*/
            if(tube.collides(bird.getBounds())){
                gsm.set(new PlayState(gsm));
            }
        }

        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        /*SpriteBatch must first be "opened" with begin then have its textures added
        * After all textures are added SpriteBach must be "closed" with end*/
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        /*Background fixed on to game camera viewport*/
        sb.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for(Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

        //dispose used to prevent any sort of memory leak
    }
}
