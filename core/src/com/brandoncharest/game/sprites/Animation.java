package com.brandoncharest.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Brandon on 4/6/2016.
 */
public class Animation {
    private Array<TextureRegion> frames;

    //how long a frame stays in few before switch
    private float maxFrameTime;
    //how long animation as been in current frame
    private float currentFrameTime;
    //number of frames in animation
    private int frameCount;
    //current frame
    private int frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames= new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;

        /*This for loop will cycle through our birdanimation.png file starting at frame zero and returning
        * the first sprite then moving on to take the next sprite in the file and so on.*/
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime= cycleTime /frameCount;
        frame = 0;
    }

    public void update(float dt){
        //time frame has been on screen
        currentFrameTime += dt;
        //moves frames up by 1
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        //restarts the frames back to starting position
        if(frame >= frameCount){
            frame=0;
        }
    }

    public TextureRegion getFrame(){
        //returns current animation
        return frames.get(frame);
    }
}
