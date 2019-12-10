/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TateM
 */
public class Bush extends GameObject {
    
    public ImageIcon bush = new ImageIcon(this.getClass().getResource("bush.png"));


    public Bush(int x, int y, ID id) {
        super(x, y, id);

    }

    public void tick() {

    }

    public void collision() {
    
    }
    
    public void render(Graphics g) {

        g.setColor(Color.green);
        //g.fillRect((int) x, (int) y, 700, 32);
        bush.paintIcon(null, g,(int) x,(int) y);
    }

    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, 640, 32);
    }

}
