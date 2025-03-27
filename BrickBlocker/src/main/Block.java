package main;
import java.awt.Color;
import java.awt.Rectangle;
//this class is for the blocks that the ball will hit and destroy.

public class Block extends Rectangle {
    // this can be used for setting various types of blocks. (Unbreakable ones, ones
    // that make the paddle smaller or larger, ones that give an extra ball...)
    // They could have different colours too.
    int type = 1;
    boolean isUnbreakable = false; // New property for unbreakable blocks
    Color colour = new Color(0, 0, 111);
    // is the block displayed on the screen?
    boolean isVisible = true;

    // constructor. Set parameters for all blocks
    Block() {
        width = 100;
        height = 20;
    }
}