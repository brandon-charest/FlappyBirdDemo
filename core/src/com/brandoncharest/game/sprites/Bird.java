package com.brandoncharest.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.brandoncharest.game.FlappyBirdDemo;

/**
 * Created by Brandon on 4/4/2016.
 */
public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    //used for collison detection on bird
    private Rectangle bounds;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity= new Vector3(0,0,0);
        bird = new Texture("bird.png");
        //sets boundry to the bird sprite for collsion detection
        bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt){
        if(position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
            velocity.scl(dt);
            position.add(0, velocity.y, 0);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if(position.y > (FlappyBirdDemo.HEIGHT / 2) -20){
            position.y = (FlappyBirdDemo.HEIGHT / 2) -20;
        }
        //stops bird from going off screen
        if(position.y < 0 ){
            position.y =0;
        }
        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void jump() {
        velocity.y=200;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
        bird.dispose();
    }
}
