
/*
 * Author: Mr McKay. 
 * Modified By: Hamad Mohammed
 * Creation Date: 08 11 2023
 * Description: Purpose of this is to be able to set ballx, bally, width or length for each element when using an array of balls . 
*/

import java.awt.Color;
import java.awt.Rectangle;

public class Ball extends Rectangle{
        int size;
        double speedX = 10;
        double speedY = 10; 
        int heightSpeed = 1; 
        private int SCREEN_WIDTH;
        private int SCREEN_HEIGHT;
    	boolean isVisible = false;
    	Color colour = new Color(0,128,255);
    	
        public Ball(int SCREEN_WIDTH, int SCREEN_HEIGHT) {
            x = SCREEN_WIDTH/4+395;
            y = 250;
            size = 30;
            this.SCREEN_WIDTH = SCREEN_WIDTH;
            this.SCREEN_HEIGHT = SCREEN_HEIGHT; 
        }
        
        
       
        
       
       
    }
	
