
import java.awt.Color;
import java.awt.Rectangle;

public class Snow extends Rectangle{
        int size;
        int speed;
        private int SCREEN_WIDTH;
        private int SCREEN_HEIGHT;
    	boolean isVisible = true;
    	Color colour = new Color(244, 246, 240);
    	
        public Snow(int SCREEN_WIDTH, int SCREEN_HEIGHT) {
            x = (int)(Math.random()*SCREEN_WIDTH)+1;
            y = (int)(Math.random()*SCREEN_HEIGHT)+1;
            size = (int)(Math.random()*3)+ 1;
            speed = (int)(Math.random()*5) + 1;
            this.SCREEN_WIDTH = SCREEN_WIDTH;
            this.SCREEN_HEIGHT = SCREEN_HEIGHT; 
        }
        
        
       
        
       
       
    }
	
