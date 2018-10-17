package com.example.kaustubh.archergame;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

public class MediumMode extends Activity {

    // Our object that will hold the view and
    // the sprite sheet animation logic
    GameView gameView;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize gameView and set it as the view
        gameView = new GameView(this);
        setContentView(gameView);


    }

    // Here is our implementation of GameView
    // It is an inner class.
    // Note how the final closing curly brace }
    // is inside SpriteSheetAnimation

    // Notice we implement runnable so we have
    // A thread and can override the run method.
    class GameView extends SurfaceView implements Runnable {

        // This is our thread
        Thread gameThread = null;


        // This is new. We need a SurfaceHolder
        // When we use Paint and Canvas in a thread
        // We will see it in action in the draw method soon.
        SurfaceHolder ourHolder;

        // A boolean which we will set and unset
        // when the game is running- or not.
        volatile boolean playing;

        // A Canvas and a Paint object
        Canvas canvas;
        Paint paint;

        // This variable tracks the game frame rate
        long fps;

        // This is used to help calculate the fps
        private long timeThisFrame;

        // Declare an object of type Bitmap
        Bitmap bitmapBob;
        Bitmap bittarget;
        Bitmap bow;
        // Bob starts off not moving
        boolean isMoving = false;

        // He can walk at 150 pixels per second
        float walkSpeedPerSecond = 150;

        // He starts 10 pixels from the left
        float bobXPosition = 0;


        float box2XPosition = 1000;
        float box2YPosition = 500;

        float box3XPosition=0;
        //float targetXPosition = 0;
        // New for the sprite sheet animation

        // These next two values can be anything you like
        // As long as the ratio doesn't distort the sprite too much
        private int frameWidth = 400;
        private int frameHeight = 600;

        private int frame2Height = 600;

        private int frame2width=800;


        // How many frames are there on the sprite sheet?
        private int frameCount =1;

        // Start at the first frame - where else?
        private int currentFrame = 0;

        // What time was it when we last changed frames
        private long lastFrameChangeTime = 0;

        // How long should each frame last
        private int frameLengthInMilliseconds = 100;

        // A rectangle to define an area of the
        // sprite sheet that represents 1 frame
        private Rect frameToDraw = new Rect(
                0,
                0,
                frameWidth,
                frameHeight);

        private Rect frame2ToDraw = new Rect(
                0,
                0,
                3800,
                frameHeight);
        private Rect frame3ToDraw = new Rect(
                0,
                0,
                3800,
                frameHeight);



        // A rect that defines an area of the screen
        // on which to draw
        RectF whereToDraw = new RectF(
                bobXPosition,  1200,
                bobXPosition + frameWidth,
                frameHeight);


        RectF whereToDraw2 = new RectF(
                box2XPosition,               50,
                box2XPosition + frameWidth,
                frameHeight);

        RectF whereToDraw3 = new RectF(
                box3XPosition,  1200,
                box3XPosition + frame2width,
                frameHeight);



        // When the we initialize (call new()) on gameView
        // This special constructor method runs
        public GameView(Context context) {
            // The next line of code asks the
            // SurfaceView class to set up our object.
            // How kind.
            super(context);

            // Initialize ourHolder and paint objects
            ourHolder = getHolder();
            paint = new Paint();


            // Load Bob from his .png file
            bitmapBob = BitmapFactory.decodeResource(this.getResources(), R.drawable.arrows);
            bittarget= BitmapFactory.decodeResource(this.getResources(),R.drawable.disk);
            bow=BitmapFactory.decodeResource(this.getResources(),R.drawable.bow);
            // Scale the bitmap to the correct size
            // We need to do this because Android automatically
            // scales bitmaps based on screen density
            bitmapBob = Bitmap.createScaledBitmap(bitmapBob,
                    frameWidth * frameCount,
                    frameHeight,
                    false);
            bittarget=Bitmap.createScaledBitmap(bittarget,
                    (frameWidth+400) * frameCount,
                    frame2Height,
                    false);
            bow=Bitmap.createScaledBitmap(bow,
                    (frameWidth+400) * frameCount,
                    frame2Height,
                    false);
            // Set our boolean to true - game on!
            //playing = true;



        }

        @Override
        public void run() {
            while (playing) {

                // Capture the current time in milliseconds in startFrameTime
                long startFrameTime = System.currentTimeMillis();

                // Update the frame
                update();

                // Draw the frame
                draw();

                // Calculate the fps this frame
                // We can then use the result to
                // time animations and more.
                timeThisFrame = System.currentTimeMillis() - startFrameTime;
                if (timeThisFrame >= 1) {
                    fps = 1000 / timeThisFrame;
                }

            }

        }

        // Everything that needs to be updated goes in here
        // In later projects we will have dozens (arrays) of objects.
        // We will also do other things like collision detection.
        public void update() {

            // If bob is moving (the player is touching the screen)
            // then move him to the right based on his target speed and the current fps.
            if(isMoving){
                bobXPosition = bobXPosition + (walkSpeedPerSecond / fps);


            }
            if(isMoving){
                box2YPosition=box2YPosition + (walkSpeedPerSecond / fps);
            }

        }

        public void getCurrentFrame(){

            long time  = System.currentTimeMillis();
            if(isMoving) {// Only animate if bob is moving
                if ( time > lastFrameChangeTime + frameLengthInMilliseconds) {
                    lastFrameChangeTime = time;
                    currentFrame++;
                    if (currentFrame >= frameCount) {

                        currentFrame = 0;
                    }
                }
            }
            //update the left and right values of the source of
            //the next frame on the spritesheet
            // frameToDraw.left = currentFrame * frameWidth;
            //frameToDraw.right = frameToDraw.left + frameWidth;


        }

        // Draw the newly updated scene
        public void draw() {

            // Make sure our drawing surface is valid or we crash
            if (ourHolder.getSurface().isValid()) {
                // Lock the canvas ready to draw
                canvas = ourHolder.lockCanvas();

                // Draw the background color
                canvas.drawColor(Color.argb(255,  128, 255, 128));

                // Choose the brush color for drawing
                paint.setColor(Color.argb(255,  249, 129, 0));

                // Make the text a bit bigger
                paint.setTextSize(45);

                // Display the current fps on the screen
                canvas.drawText("FPS:" + fps, 20, 70, paint);


                if(bobXPosition>= 680){
                    canvas.drawText("FPS:" + "REACHED !!", 20, 800, paint);
                    bobXPosition = 0;
                    Intent intent = new Intent(MediumMode.this,Decision.class);
                    startActivity(intent);

                }
                else {
                    canvas.drawText("FPS:" + bobXPosition, 20, 800, paint);
                }


                // Draw bob at bobXPosition, 200 pixels
                //canvas.drawBitmap(bitmapBob, bobXPosition, 200, paint);

                whereToDraw.set((int)bobXPosition,
                        240,
                        (int)bobXPosition + frameWidth,
                        frameHeight);

                //whereToDraw2
                whereToDraw2.set((int)box2XPosition,
                        200,
                        (int)box2XPosition+600,
                        frame2Height);
                whereToDraw3.set((int)box3XPosition,
                        240,
                        (int)box2XPosition+600,
                        frame2Height);

                getCurrentFrame();

                canvas.drawBitmap(bitmapBob,
                        frameToDraw,
                        whereToDraw, paint);
                canvas.drawBitmap(bittarget,frame2ToDraw,whereToDraw2,paint);
                canvas.drawBitmap(bow,frame3ToDraw,whereToDraw3,paint);
                // Draw everything to the screen
                ourHolder.unlockCanvasAndPost(canvas);
            }

        }

        // If SimpleGameEngine Activity is paused/stopped
        // shutdown our thread.
        public void pause() {
            playing = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                Log.e("Error:", "joining thread");
            }

        }

        // If SimpleGameEngine Activity is started theb
        // start our thread.
        public void resume() {
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }

        // The SurfaceView class implements onTouchListener
        // So we can override this method and detect screen touches.
        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {

            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                // Player has touched the screen
                case MotionEvent.ACTION_DOWN:

                    // Set isMoving so Bob is moved in the update method
                    isMoving = true;

                    break;

                // Player has removed finger from screen
                case MotionEvent.ACTION_UP:

                    // Set isMoving so Bob does not move
                    isMoving = false;

                    break;
            }
            return true;
        }

    }
    // This is the end of our GameView inner class

    // This method executes when the player starts the game
    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        gameView.resume();
    }

    // This method executes when the player quits the game
    @Override
    protected void onPause() {
        super.onPause();


        // Tell the gameView pause method to execute
        gameView.pause();
    }

}