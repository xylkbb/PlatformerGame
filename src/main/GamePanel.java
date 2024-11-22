package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;



public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    // TODO: Note.  I'll do the one below.  We need a 2d array to handle the table of sprite poses in player_sprites.png
    // This is a bit of an early topic, but its like a list that contains lists.  The first list if the row, the ones inside are the
    // columns.  This will handle the animations.
    private BufferedImage[][] animations;
    // TODO: These new fields are just private
    int aniTick;
    int aniIndex = 15;
    int aniSpeed;
    int playerAction = IDLE;
    int playerDir = -1;
    boolean moving = false;
    // TODO: create an int named aniTick, aniIndex, and aniSpeed and initialize aniSpeed to 15;
    // TODO: create an int named playerAction and initialize to IDLE (this comes from the Constants file imported above)
    // TODO: create an int named playerDir and initialize to -1
    // TODO: create a boolean named moving and initialize to false.

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImg();
        loadAnimations();
        // TODO: we will create a method below named loadAnimations.  Call it here as loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];  // TODO: note  We have 9 rows, 6 columns see how this 2D array works.  :)
        // TODO: Note:  We are going to loop through this 2d array we need a loop in a loop the outer one goes row by row.
        // when we land on a row we have to go left to right through the columns.
        for (int row = 0; row < animations.length; row++) {  // TODO: note:  the number of rows is the length of the array the first set brackets
            for (int col = 0; col < animations[row].length; col++) { // TODO: note:  once we hit a row its length animations[row].length is the column size.
                animations[row][col] = img.getSubimage(row * 64, col * 40, 64, 40); // TODO: note:  the sprite
                // width is 40 and its height is 64. The row number * height will move up and down. The col number * width goes left to right.
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void setDirection(int direction) {
        // TODO: Note: is red.  I gave this part to you but the red will vanish when variable fields are created.
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        // TODO: Note: is red.  I gave this part to you but the red will vanish when variable fields are created.
        this.moving = moving;
    }

    private void updateAnimationTick() {
        // TODO: Note: this is more or less the clock for the animations.  It handles the pose cycle
        aniTick++;

        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
        // TODO: add 1 to aniTick with ++
        // TODO: if aniTick >= aniSpeed.
        // TODO: The rest of this method is all in the if block started at previous line.
        // TODO: set aniTick to 0
        // TODO: add 1 to aniIndex with ++
        // TODO: if aniIndex >= GetSpriteAmount(playerAction)
        // TODO: inside this if statement set aniIndex to 0
        // TODO: This is easy to mess up.  You'll have an if in and if at the end of the day.
    }

    private void setAnimation() {
        if (moving) {
            playerAction = RUNNING;
        } else {

            playerAction = IDLE;
        }
        // TODO: if moving set playerAction to RUNNING
        // TODO: else set playerAction to IDLE
    }

    private void updatePos() {
        // TODO: Note:  there will be red here because it depends on other components that you'll finish.  Don't worry.
        if (moving) {
            switch (playerDir) {
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -= 5;
                    break;
                case RIGHT:
                    xDelta += 5;
                    break;
                case DOWN:
                    yDelta += 5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePos();
        // TODO: Note:  and here is where the magic occurs. Basically when you move or perform an action
        // The playerActions are the rows of the player_sprite.png image.
        // The aniIndex is the column.  So when paintComponent is called by the thread it accesses these two variables
        // and uses them to chose the subImage from animations
        // and draws it at the locations and size.
        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);

    }

}