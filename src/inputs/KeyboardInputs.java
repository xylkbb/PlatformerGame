package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import static utilz.Constants.Directions.*;


public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D:
                gamePanel.setMoving(false);
                break;
            // TODO: case KeyEvent.VK_W:
            // TODO: case KeyEvent.VK_A:
            // TODO: case KeyEvent.VK_S:
            // TODO: case KeyEvent.VK_D:
            // TODO: the above cases fall through to case VK_D where you do the following
            // TODO: gamePanel.setMoving(false)
            // TODO: break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: don't do anything here.  UP, LEFT, DOWN, and RIGHT come from Constants.  Once you finish them
        // These shouldn't be red as I've already included the import.  above.
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(RIGHT);
                break;
        }

    }

}