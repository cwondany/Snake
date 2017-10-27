/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import snake.control.GameController;

/**
 *
 * @author cw
 */
public class SidePanel extends JPanel {

    /**
     * The medium font to draw with.
     */
    private static final Font MEDIUM_FONT = new Font("Arial", Font.BOLD, 14);
    /**
     * The small font to draw with.
     */
    private static final Font SMALL_FONT = new Font("Arial", Font.BOLD, 9);
    /**
     * The SnakeGame instance.
     */
    private GameController game;

    /**
     * Creates a new SidePanel instance.
     *
     * @param game The SnakeGame instance.
     */
    public SidePanel(GameController game) {
        this.game = game;

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(125, 50));
    }
    // Offsets in order to draw the Strings on SidePanel:
    private static final int STATISTICS_OFFSET = 100;
    private static final int CONTROLS_OFFSET = 200;
    private static final int MESSAGE_STRIDE = 20;
    private static final int SMALL_OFFSET = 25;
    private static final int LARGE_OFFSET = 50;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.repaint();

        /*
	 * Set the color to draw the font in to white.
         */
        g.setColor(Color.WHITE);
        /*
	 * Draw the game name onto the window.
         */
        g.setFont(MEDIUM_FONT);
        g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 50);

        /*
	 * Draw the categories onto the window.
         */
        g.setFont(MEDIUM_FONT);
        g.drawString("Statistics", SMALL_OFFSET, STATISTICS_OFFSET);
        g.drawString("Controls", SMALL_OFFSET, CONTROLS_OFFSET);

        /*
	 * Draw the category content onto the window.
         */
        g.setFont(SMALL_FONT);

        //Draw the content for the statistics category.
        int drawY = STATISTICS_OFFSET;
        g.drawString("Total Score: " + game.getScore(), SMALL_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Fruit Eaten: " + game.getFruitScore(), SMALL_OFFSET, drawY += MESSAGE_STRIDE);
//		//Draw the content for the controls category.
        drawY = CONTROLS_OFFSET;
        g.drawString("Up Arrowkey", SMALL_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Down Arrowkey", SMALL_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Left Arrowkey", SMALL_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Right Arrowkey", SMALL_OFFSET, drawY += MESSAGE_STRIDE);

    }
}
