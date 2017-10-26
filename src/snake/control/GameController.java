/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import snake.model.Apple;
import snake.model.Direction;
import snake.model.Piece;
import snake.model.Snake;

/**
 *
 * @author cw
 */
 
public class GameController extends Timer implements ActionListener {
 
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Snake snake;
    private Apple apple;
 
    public GameController(int width, int height) {
        super(1000, null);
 
        this.width = width;
        this.height = height;
        this.continues = true;
 
        addActionListener(this);
 
        snake = new Snake(width / 2, height / 2, Direction.DOWN);
        newApple();
    }
 
    public Snake getWorm() {
        return snake;
    }
 
    public void setApple(Apple apple) {
        this.apple = apple;
    }
 
    public void setWorm(Snake worm) {
        this.snake = worm;
    }
 
    public Apple getApple() {
        return apple;
    }
 
    public boolean continues() {
        return continues;
    }
 
    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
 
        snake.move();
        if (snake.runsInto(apple)) {
            snake.grow();
            newApple();
        }
        if (snake.runsIntoItself() || wormHitsBorder()) {
            continues = false;
        }
 
        updatable.update();
        setDelay(800 / snake.getLength());
    }
 
    private void newApple() {
        while (true) {
            Random random = new Random();
            apple = new Apple(random.nextInt(width), random.nextInt(height));
            if (!snake.runsInto(apple)) {
                break;
            }
        }
    }
 
    private boolean wormHitsBorder() {
        for (Piece p : snake.getPieces()) {
            if (p.getY() == height || p.getX() == width || p.getX() == -1 || p.getY() == -1) {
                return true;
            }
        }
        return false;
    }
}