/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.view;

import java.awt.BorderLayout;
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
    private SidePanel sidePanel;

    public UserInterface(GameController game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        frame.setLayout(new BorderLayout());

        int width = ((game.getWidth() + 1) * sideLength)+10 ;
        int height = ((game.getHeight() + 1) * sideLength)+110 ;

        frame.setPreferredSize(new Dimension(height, width));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sidePanel = new SidePanel(game);
        frame.add(sidePanel, BorderLayout.EAST);
        
        createComponents(frame.getContentPane());
         board = new DrawingBoard(game, sideLength);
        frame.add(board,BorderLayout.CENTER);


        frame.pack();
        frame.repaint();
        frame.setVisible(true);

    }

    private void createComponents(Container container) { 
        KeyboardListener k = new KeyboardListener(game.getWorm(),game);
        getFrame().addKeyListener(k);
    }
    public JFrame getFrame() {
        return frame;
    }

    public Updatable getUpdatable() {
        return board;
    }

}
