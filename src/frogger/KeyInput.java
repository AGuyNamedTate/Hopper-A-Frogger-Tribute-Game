package frogger;

import frogger.ID;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author TateM
 */
//so we can use keys
public class KeyInput extends KeyAdapter {

    private Handler handler;
    Player player;

    public KeyInput(Handler handler) {

        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for player 1
                if (key == KeyEvent.VK_W) {
                    tempObject.setY(-32);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setY(32);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setX(-32);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setX(32);
                }
            }
            // for player 2
            if (tempObject.getId() == ID.Player) {
                //another way to use if statements
                /* if (key == KeyEvent.VK_UP) {
                 tempObject.setY(tempObject.getY() - 1);
                 */
                if (key == KeyEvent.VK_UP) {
                    tempObject.setY(-32);
                    
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setY(32);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setX(-32);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setX(32);
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {

            System.exit(0);

        }
    }

//System.out.println(key);
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for player 1
                if (key == KeyEvent.VK_W) {
                    tempObject.setY(-0);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setY(0);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setX(-0);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setX(0);
                }
            }
            // for player 2
            if (tempObject.getId() == ID.Player) {
                //another way to use if statements
                /* if (key == KeyEvent.VK_UP) {
                 tempObject.setY(tempObject.getY() -0);
                 */
                if (key == KeyEvent.VK_UP) {
                    tempObject.setY(-0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setY(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setX(-0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setX(0);
                }
            }
        }
    }
}
