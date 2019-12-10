
package frogger;

import frogger.Frogger;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


/**
 *
 * @author TateM
 */
public class Window extends Canvas {
    private static final long serialVersionUID = -2408406005333728354L;
    public Window( int width, int height, String title, Frogger game){
    JFrame frame = new JFrame(title);
    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width,height));
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.add(game); 
    game.start();
    
}
    
}
