/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.view;

import snake.control.Updatable;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snake.control.GameController;
import snake.model.Apple;
import snake.model.Piece;

/**
 *
 * @author cw
 */
public class DrawingBoard extends JPanel implements Updatable {
    
    private GameController wormGame;
    private int sideLength;

    public DrawingBoard(GameController wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.sideLength = pieceLength;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        Apple apple = wormGame.getApple();
        g.fillOval(sideLength * apple.getX(), sideLength * apple.getY(), sideLength, sideLength);
 
        g.setColor(Color.BLACK);
        for (Piece p : wormGame.getWorm().getPieces()) {
            g.fill3DRect(sideLength * p.getX(), sideLength * p.getY(), sideLength, sideLength, true);
        }
    }

    @Override
    public void update() {
        this.repaint();
    }
}
