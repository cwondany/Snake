/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import snake.control.GameController;
import javax.swing.SwingUtilities;
import snake.view.UserInterface;

/**
 *
 * @author cw
 */
public class Main {
 
    public static void main(String[] args) {
        
        
   
        GameController game = new GameController(20, 20);
 
        UserInterface ui = new UserInterface(game, 30);
        SwingUtilities.invokeLater(ui);
 
        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }
 
        game.setUpdatable(ui.getUpdatable());
        game.start();
    }
}