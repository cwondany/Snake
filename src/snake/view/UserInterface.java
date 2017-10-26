/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.view;

import snake.control.KeyboardListener;
import snake.control.Updatable;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import snake.control.GameController;

/**
 *
 * @author cw
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private GameController game;
    private int sideLength;
    private DrawingBoard board;

    public UserInterface(GameController game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        int width = (game.getWidth() + 1) * sideLength + 10;
        int height = (game.getHeight() + 2) * sideLength + 10;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        board = new DrawingBoard(game, sideLength);
        container.add(board);
        KeyboardListener k = new KeyboardListener(game.getWorm());
        getFrame().addKeyListener(k);
    }

    public JFrame getFrame() {
        return frame;
    }
     public Updatable getUpdatable() {
        return board;
    }

}
