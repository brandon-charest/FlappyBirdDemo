package com.brandoncharest.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Brandon on 4/4/2016.
 */
public class Tube {
    /*allows for the position of tubes to move vertically 130px.*/
    private static final int FLUCTUATION = 130;
    /*the distance between the tubes will be 100px*/
    private static final int TUBE_GAP = 100;
    /*lostest possible position for top tube 120px*/
    private static final int LOWEST_OPENING =120;
    public static final int TUBE_WIDTH = 52;
    private Texture topTube;
    private Texture bottomTube;
    private Vector2 posTopTube, posBotTube;

    /*Random used for the random placement of tubes.*/
    private Random random;

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        random = new Random();

        posTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
    }

    public void Reposition(float x){
        posTopTube.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
    }

}
