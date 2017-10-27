/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.control;

/**
 *
 * @author cw
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snake.model.Direction;
import snake.model.Snake;

public class KeyboardListener implements KeyListener {

    private Snake worm;
    private GameController game;

    public KeyboardListener(Snake worm, GameController game) {
        this.worm = worm;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            worm.setDirection(Direction.UP);
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            worm.setDirection(Direction.DOWN);
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            worm.setDirection(Direction.RIGHT);
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            worm.setDirection(Direction.LEFT);
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
