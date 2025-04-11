
import java.awt.*;

import hsa2.GraphicsConsole;

public class Main {
    
    Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
    private  int screenW =  rect.width;
    private  int screenH = rect.height;

    private static Snow[] snow = new Snow[100];
    private GraphicsConsole gc = new GraphicsConsole(screenW, screenH);
    private boolean snowIncrease = true; 
	private Rectangle floor = new Rectangle(0, 0, screenW, 50); // set width and height here
    private static boolean snowVisible = true; 
    int ballSpeedY = 5; 
    int ballSpeedX = 5; 
    int ballCounter = 1;
    private static boolean firstAnimation = true; 
    private static boolean secondAnimation = false; 
    private static boolean thirdAnimation = false; 

    private static Ball ball = new Ball(50, 50); 

    // Variables. 
    private double[] scales; // Array to store scaling factors for each set
    private double[] angles; // Array to store rotation angles for each set
    private int dotCount = 50;
    private int dotSize = 8;
    private int numSets = 50; // Number of sets of spinning dots


    // Initializing Objects. 
    private Point[][] dotPositions;



    private Main() { 
        // ANIMATION 1
    	if(firstAnimation) {
            initialize();
            gc.setBackgroundColor(new Color(0, 0, 0));
            }
            while(firstAnimation) {
            moveSnow();
            drawGraphics(); 
            }
            
            // ANIMATION 2
            if(secondAnimation) {
                gc.setAntiAlias(true);
                gc.setBackgroundColor(new Color(0, 0, 0));
            }
            while(secondAnimation) {
            moveBall(); 
            drawGraphics2();
            }

            // ANIMATION 3
    	if(thirdAnimation) {
    		initialize3();
    	}
    	while(thirdAnimation) {
    		move(); 
    		drawGraphics3();
    	}

    }


    
    private void initialize() {
    	// Set Font
    	gc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		gc.setAntiAlias(true);
		// set snow color. 
		gc.setColor(Color.white);
		floor.x = 0; 
		floor.y = screenH-20; 
		for (int i = 0; i < 100; i++) {
			// Initialize snow array elements. 
            snow[i] = new Snow(screenW, screenH); 
            // Random snow x and y initial position. 
            snow[i].x =  (int)(Math.random()*screenW)+1;
            snow[i].y = (int)(Math.random()*screenH)+1;
            
        }
    }

    private void drawGraphics2() {
    	synchronized(gc) {
    		gc.clear();
    		gc.sleep(10);
			// gc.setColor(ball.colour);	// Set ball Color. 
			
            gc.setColor(ball.colour);
            gc.fillOval(ball.x, ball.y, ball.size, ball.size);
    		
    	} // end Sync
    } // 

    private void initialize3() {
		gc.setBackgroundColor(Color.black);
		gc.clear();
		rect.x = screenW/2; 
		rect.y = screenH/2-200; 
		rect.width = 30; 
		rect.height = 10;
		// initialize arrays and array lengths. 
		dotPositions = new Point[numSets][dotCount];
	    angles = new double[numSets];
	    scales = new double[numSets];
	    
	    // Set initial array values. 
	      for (int i = 0; i < numSets; i++) {
	          angles[i] = 0.0;
	          scales[i] = 1.0;
	
	          for (int j = 0; j < dotCount; j++) {
	              dotPositions[i][j] = new Point();
	          }
	      }
	}

    private void drawGraphics() {



    	synchronized(gc) {
    		gc.clear();	
    		gc.sleep(10);
            gc.fillOval(100, 100, 40, 30);
            gc.fillOval(100+10, 100-10,40, 30);
            gc.fillOval(100+20, 100, 40, 30);
            gc.fillOval(100+30, 100-10,40, 30);
            gc.fillOval(100+40, 100, 40, 30);
            gc.fillOval(100+50, 100-10,40, 30);

            gc.fillOval(600, 200, 40, 30);
            gc.fillOval(600+10, 200-10,40, 30);
            gc.fillOval(600+20, 200, 40, 30);
            gc.fillOval(600+30, 200-10,40, 30);
            gc.fillOval(600+40, 200, 40, 30);
            gc.fillOval(600+50, 200-10,40, 30);

            gc.fillOval(1200, 150, 40, 30);
            gc.fillOval(1200+10, 150-10,40, 30);
            gc.fillOval(1200+20, 150, 40, 30);
            gc.fillOval(1200+30, 150-10,40, 30);
            gc.fillOval(1200+40, 150, 40, 30);
            gc.fillOval(1200+50, 150-10,40, 30);

            gc.fillOval(900, 50, 40, 30);
            gc.fillOval(900+10, 50-10,40, 30);
            gc.fillOval(900+20, 50, 40, 30);
            gc.fillOval(900+30, 50-10,40, 30);
            gc.fillOval(900+40, 50, 40, 30);
            gc.fillOval(900+50, 50-10,40, 30);

            gc.fillOval(300, 50, 40, 30);
            gc.fillOval(300+10, 50-10,40, 30);
            gc.fillOval(300+20, 50, 40, 30);
            gc.fillOval(300+30, 50-10,40, 30);
            gc.fillOval(300+40, 50, 40, 30);
            gc.fillOval(300+50, 50-10,40, 30);

            gc.fillOval(1400, 50, 40, 30);
            gc.fillOval(1400+10, 50-10,40, 30);
            gc.fillOval(1400+20, 50, 40, 30);
            gc.fillOval(1400+30, 50-10,40, 30);
            gc.fillOval(1400+40, 50, 40, 30);
            gc.fillOval(1400+50, 50-10,40, 30);

            gc.fillOval(1700, 125, 40, 30);
            gc.fillOval(1700+10, 125-10,40, 30);
            gc.fillOval(1700+20, 125, 40, 30);
            gc.fillOval(1700+30, 125-10,40, 30);
            gc.fillOval(1700+40, 125, 40, 30);
            gc.fillOval(1700+50, 125-10,40, 30);

    		for (int i = 0; i < snow.length; i++) {
    			// Generate Snow. 
				if (snow[i].isVisible) {
					if(snowVisible) {
					gc.setColor(snow[i].colour);
					gc.fillOval(snow[i].x, snow[i].y, snow[i].size, snow[i].size);
					}
					// Generate Moon. 					// Slowly turn it into daytime. 
					
				}
	    		gc.fillRoundRect(floor.x, floor.y, floor.width, floor.height+500, 10, 10);
			}
    	}
    }

    private void moveBall() {
        gc.sleep(5);
        ball.isVisible = true; 

                ball.y += ball.speedY;   
                ball.x += ball.speedX;   

                if(ball.size > 300) { 
                    secondAnimation = false; 
                    thirdAnimation = true; 
                }
                
                if(ball.y >= screenH) { 
                    ball.y = screenH - 10; 
                    ball.speedY *= -1; 
                    ball.colour = new Color((int)(Math.random() * 0x1000000));
                    ball.size += 50;
                }
        
                if(ball.y <= 0) { 
                    ball.y = 10; 
                    ball.speedY *= -1;
                    ball.colour = new Color((int)(Math.random() * 0x1000000));
                    ball.size += 50;

                }
        
                if(ball.x >= screenW) { 
                    ball.x = screenW - 10; 
                    ball.speedX *= -1;
                    ball.colour = new Color((int)(Math.random() * 0x1000000));
                    ball.size += 50;

                }
        
                if(ball.x < 0) { 
                    ball.x = 10; 
                    ball.speedX *= -1;
                    ball.colour = new Color((int)(Math.random() * 0x1000000));
                    ball.size += 50;


                }

        // bottom
       
    }

    private void drawGraphics3() {
		synchronized(gc) {
		gc.clear();
		gc.sleep(10);
		// Reset Strokes. 
		gc.setStroke(1);
		// Random Colors. 
		gc.setColor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
		
		// Print Dots
		for(int i = 0; i < numSets; i++) {	
			for(int j = 0; j < dotCount; j++ ) {
			Point dot = dotPositions[i][j];
		    gc.fillOval(dot.x - dotSize / 2, dot.y - dotSize / 2, dotSize, dotSize);
		 
		// Reset Animation. 
	       if (scales[i] > 1.5) {
	        scales[i] = 1.0;
	    }
	    
	   // Draw Lines Connecting the Dots. 
		  if (j < dotCount - 1) {
	            Point nextDot = dotPositions[i][j + 1];
	            gc.drawLine(dot.x, dot.y, nextDot.x, nextDot.y);
	        }
		}
	   // Initial Line to connect dots. 
			  Point firstDot = dotPositions[i][0];
	          Point lastDot = dotPositions[i][dotCount - 1];
	          gc.drawLine(lastDot.x, lastDot.y, firstDot.x, firstDot.y);
	          
		} // end for	  	
		} // end sync
	} // end method.

    private void move() {
        gc.sleep(5);
        // Update angles and scaling factor for each set.
         for (int i = 0; i < numSets; i++) {
                angles[i] += 0.05;
                scales[i] += 0.002;
                for (int j = 0; j < dotCount; j++) {
                    double theta = 2 * Math.PI * j / dotCount;
                    int radius = 100 + i * 50; // Vary the radius for each set
                    int centerX = screenW / 2; 
                    int centerY = screenH / 2;
                    // Calculate x and y position after moving for each dot. 
                    int x = (int) (centerX + scales[i] * radius * Math.cos(theta + angles[i]));
                    int y = (int) (centerY + scales[i] * radius * Math.sin(theta + angles[i]));
    
                    // Update dot positions
                    dotPositions[i][j].move(x, y);
                }
            }
    }    

    private void moveSnow() { 
        gc.sleep(5);
        gc.setBackgroundColor(new Color(0, 0/2, 0));
        if(floor.y < 950) {
            firstAnimation = false;
            secondAnimation = true; 
        }
        for(int i = 0; i < snow.length; i++) { 
            snow[i].y += snow[i].speed;
    		// Reset snow position when it reaches the bottom. 
        	 if (snow[i].y > screenH) {
                 snow[i].y = 0;
                 snow[i].x = (int)(Math.random()*screenW)+1;	// Random X position whenever it resets.
                 snow[i].size = (int)(Math.random()*3)+ 1;		// Random size whenever it resets.
                 snow[i].speed = (int)(Math.random()*5) + 1;	// Random speed whenever it resets. 
                
                 // Increase the snow platform and move the moon/sun. 
                 if(snowIncrease) {
                    if(floor.y >= screenH-200)
                    floor.y -= 1;  
                 }
                }
        }
    }

    public static void main(String[] args) {
        new Main();    
    }
}
