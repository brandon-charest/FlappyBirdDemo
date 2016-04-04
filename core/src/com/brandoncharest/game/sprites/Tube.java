package com.brandoncharest.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
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
    /*lowest possible position for top tube 120px*/
    private static final int LOWEST_OPENING =120;
    public static final int TUBE_WIDTH = 52;
    private Rectangle boundsTop, boundsBot;
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

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }
    /*this method takes the tubes that have passed out of few from the game screen and rerenders them up ahead off screen*/
    public void Reposition(float x){
        posTopTube.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        //sets boundrys on tubes again after they are recreated
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides(Rectangle player){
        /*checks to see if player as encountered a tube*/
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

}
