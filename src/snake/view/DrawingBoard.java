/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.view;

import snake.control.Updatable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

    private GameController game;
    private int sideLength;
    /**
     * The font to draw the text with.
     */
    private static final Font FONT = new Font("Tahoma", Font.BOLD, 25);

    public DrawingBoard(GameController wormGame, int pieceLength) {
        this.game = wormGame;
        this.sideLength = pieceLength;
        this.setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        for (int x = 0; x < game.getHeight(); x++) {
            for (int y = 0; y < getWidth(); y++) {
                g.drawLine(x * sideLength, 0, x * sideLength, getHeight());
                g.drawLine(0, y * sideLength, getWidth(), y * sideLength);
            }
        }
        g.setColor(Color.RED);
        Apple apple = game.getApple();
        g.fillOval(sideLength * apple.getX(), sideLength * apple.getY(), sideLength, sideLength);

        g.setColor(Color.BLACK);
        for (Piece p : game.getWorm().getPieces()) {
            g.fill3DRect(sideLength * p.getX(), sideLength * p.getY(), sideLength, sideLength, true);
        }

        if (!game.continues()) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            String largeMessage = null;
            
            largeMessage = "Game Over!";
            /*
             * Set the message font and draw the messages in the center of the board.
             */
            g.setFont(FONT);
            g.setColor(Color.darkGray);
            g.drawString(largeMessage, centerX - g.getFontMetrics().stringWidth(largeMessage) / 2, centerY - 50);
         
        }

    }

    @Override
    public void update() {
        this.repaint();
    }
}
