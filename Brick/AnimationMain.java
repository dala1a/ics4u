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

    // so it's really easy to find and change when needed
    /***** Global (instance) Variables ******/
    GraphicsConsole gc = new GraphicsConsole(GRWIDTH, GRHEIGHT);
    Ball ball = new Ball(GRWIDTH, 100);
    Rectangle paddle = new Rectangle(0, 0, 100, 16); // set width and height here
    int lives;
    boolean isPlaying = true;

    /****** Constructor ********/
    AnimationMain() {
        initialize();
        // main game loop
        while (gc.getKeyCode() != 'Q' && isPlaying) { // press q to quit
            moveBall();
            // movePaddle();
            // checkCollisions();
            drawGraphics();
            gc.sleep(SLEEPTIME);
            if (lives <= 0)
                isPlaying = false;
        }
        gc.drawString("GAME OVER", 30, 30);
    }

    /****** Methods for game *******/
    void initialize() {
        gc.setAntiAlias(true);
        gc.setBackgroundColor(Color.BLACK);
        ball = new Ball(GRWIDTH, 100); // the ball will start somewhere in this section of the screen (but at least 75
                                       // pixels from the edges of this region)
    }

    void moveBall() {
        ball.x += ball.xspeed;
        ball.y += ball.yspeed;
        // bounce off bottom of screen
        if (ball.y > gc.getDrawHeight()) {
            ball.yspeed *= -1;
            lives--;
            ball.colour = new Color(Color.HSBtoRGB((float) Math.random(), 1.0f, 1.0f));
        }
        // right side of screen
        if (ball.x > gc.getDrawWidth()) {
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
    }

    void drawGraphics() {
        // clear screen and redraw everything
        synchronized (gc) {
            gc.clear();
            gc.setColor(Color.WHITE);
            gc.drawString("LIVES = " + lives, 30, 70);
            gc.setColor(ball.colour);
            gc.fillOval(ball.x, ball.y, ball.width, ball.height);
        }
    }
}