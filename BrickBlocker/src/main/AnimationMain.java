package main;
import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class AnimationMain {
    public static void main(String[] args) {
        new AnimationMain();
    }

    /***** Constants *****/
    static final int SLEEPTIME = 10;
    static final int GRWIDTH = 800;
    static final int GRHEIGHT = 600;
    static final Color PADDLECOLOUR = Color.YELLOW;
    static final int NUMBLOCKS = 6;

    /***** Global (instance) Variables ******/
    private GraphicsConsole gc = new GraphicsConsole(GRWIDTH, GRHEIGHT);
    private Ball ball = new Ball(GRWIDTH,200);
    private Rectangle paddle = new Rectangle(0, 0, 100, 16); // set width and height here
    private Block[] blocks = new Block[NUMBLOCKS]; // this just makes the array, it doesn't create the blocks!
    private int lives;
    private boolean isPlaying = true;
    private int blockX = 120;
    private int blockY = 60;
    private int score = 0;
    private boolean win = false;
    private boolean isDone = false;
    private long messageStartTime = 0; // Track when the message starts displaying
    private boolean isSuperBall = false;


    /****** Constructor ********/
    private AnimationMain() {
        initialize();
        // main game loop
        while (gc.getKeyCode() != 'Q' && isPlaying) { // press q to quit
            if (gc.getKeyCode() == '1' && isSuperBall == false) {
                isSuperBall = true; // Activate Super Ball mode
                ball.width -= 10; // Make the ball smaller
                ball.height -= 10;
                ball.xspeed += 4; // Increase velocity
                ball.yspeed += 4;
            }
            movePaddle_mouse();
            movePaddle_keys();
            moveBall();
            drawGraphics();
            gc.sleep(SLEEPTIME);
            if (lives <= 0) {
                win = false;
                isPlaying = false;
            }
            else {
                win = true;
                for (int i = 0; i < blocks.length; i++) {
                    if (blocks[i].isVisible && !blocks[i].isUnbreakable) {
                        win = false;
                    }
                }
                if (win == true) {
                    isPlaying = false;
                }
            }
        }

        if (win == true)
            gc.drawString("GAME OVER, You win!", GRHEIGHT/2, GRWIDTH/2);
        else
            gc.drawString("GAME OVER, You lost.", GRHEIGHT/2, GRWIDTH/2);
    }

    /****** Methods for game *******/
    /*
     * These are things that are only done once.
     * They should not be done over and over in a loop as they will either slow
     * the program down or screw it up.
     * Putting all of the initialization in a separate method is useful because
     * then it is really easy to restart the game.
     * 
     */
    private void initialize() {
        // set up gc
        gc.setFont(new Font("Georgia", Font.PLAIN, 25));
        gc.setAntiAlias(true);
        gc.setBackgroundColor(Color.BLACK);
        gc.enableMouseMotion(); // only needed for mouse (obviously)
        gc.clear();
        // set up variables
        lives = 4;
        isPlaying = true;
        // set up objects
        paddle.x = GRWIDTH / 2;
        paddle.y = GRHEIGHT - 100;
        ball.resetXY(); // This is totally unnecessary unless you restart and need to reset the ball
                        // position and speed.
        // make all blocks. ** I"m only making one row of 6 blocks. You can figure out
        // how to make more.
        for (int i = 0, j = 0; i < blocks.length; i++) { // instead of NUMBLOCKS I could use blocks.length
            blocks[i] = new Block();
            blocks[i].x = blockX * j + 35; 
            blocks[i].y = blockY;
            j++;
            if (j >= 6) {
                blockY += 50;
                j = 0;
            }
          
        }

        // Add an unbreakable block
    Block unbreakableBlock = new Block();
    int random = (int) (Math.random() * NUMBLOCKS-1);
    unbreakableBlock.x = blocks[random].x;
    unbreakableBlock.y = blocks[random].y;
    unbreakableBlock.isUnbreakable = true;
    unbreakableBlock.colour = Color.GRAY; // Different color for unbreakable blocks
    blocks[random] = unbreakableBlock; // Replace the first block with the unbreakable block
        gc.sleep(500); // allow a bit of time for the user to move the mouse to the correct position in
                       // the game screen
    }

    /**
     * This method moves the ball and handles all collisions where the ball hits
     * something.
     * Don't make a separate method to see if the paddle hits the ball.
     */
    private void moveBall() {
        ball.x += ball.xspeed;
        ball.y += ball.yspeed;
         // Change ball color dynamically if Super Ball mode is active
    if (isSuperBall) {
        ball.colour = new Color(Color.HSBtoRGB((float) Math.random(), 1.0f, 1.0f));
    }
        // bounce off bottom of screen
        if ((ball.y + ball.diameter) > gc.getDrawHeight()) {
            ball.yspeed *= -1;
            lives--;
            ball.colour = new Color(Color.HSBtoRGB((float) Math.random(),
                    1.0f, 1.0f));
        }
        // right side of screen
        if ((ball.x + ball.diameter) > gc.getDrawWidth()) {
            ball.xspeed *= -1;
        }
        // top of screen
        if (ball.y < 0) {
            ball.yspeed *= -1;
            ball.yspeed++;
        }
        // left side of screen
        if (ball.x < 0) {
            ball.xspeed *= -1;
        }
        // check if ball hits paddle
        if (ball.intersects(paddle)) {
            if (ball.yspeed > 0) { // the ball must be moving downwards, not upwards
                ball.yspeed *= -1;
            }
        }
        // see if ball hits block
        for (int i = 0; i < blocks.length; i++) {
            if (ball.intersects(blocks[i])) {
                if (!blocks[i].isUnbreakable) { // Only remove breakable blocks
                blocks[i].isVisible = false; // don't bother drawing it on the screen
                blocks[i].y = -100; // move it off the screen
                score++;    
            }
                ball.yspeed *= -1;
                
            }
        }
    }

    private void movePaddle_mouse() {
        paddle.x = gc.getMouseX() - paddle.width / 2;
    }

    private void movePaddle_keys() {
        int moveAmount = 7;
        // 37 and 39 are the keyboard codes for the left and right arrow keys.
        if (gc.getKeyCode() == 37)
            paddle.x -= moveAmount;
        if (gc.getKeyCode() == 39)
            paddle.x += moveAmount;
        // check to prevent moving the paddle off the screen
        if (paddle.x < 0)
            paddle.x = 0;
        // now you need to figure out how to to the same for the right side of the
        // screen (I did the easy one!)
    }

    private void drawGraphics() {
        // clear screen and redraw everything
        synchronized (gc) {
            gc.clear();
            gc.setColor(ball.colour);
            gc.fillOval(ball.x, ball.y, ball.width, ball.height);
            // DEBUG
            gc.setColor(Color.WHITE);
            gc.drawRect(ball.x, ball.y, ball.width, ball.height);
            // END DEBUG
            gc.setColor(PADDLECOLOUR);
            gc.fillRoundRect(paddle.x, paddle.y, paddle.width, paddle.height,
                    10, 10);
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i].isVisible) {
                    gc.setColor(blocks[i].colour);
                    gc.fillRect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
                }
            }
            gc.setColor(Color.WHITE);
            gc.drawString("LIVES: " + lives, 30, 50);
            gc.drawString("SCORE: " + score, GRWIDTH - 200, 50);
           // Display the message for 2 seconds
        if (score >= NUMBLOCKS/2 && !isDone) {
            gc.drawString("Make this HARDER!", GRWIDTH / 2 - 50, GRHEIGHT / 2 - 50);
            if (messageStartTime == 0) {
                messageStartTime = System.currentTimeMillis(); // Record the start time
            }
        }

        // Check if 2 seconds have passed since the message started
        if (messageStartTime > 0 && System.currentTimeMillis() - messageStartTime > 2000) {
            isDone = true; // Mark the message as done
            ball.xspeed += 2;
            ball.yspeed += 2;
            paddle.width -= 30;
            messageStartTime = 0; // Reset the timer
        }

    }
    }
}

