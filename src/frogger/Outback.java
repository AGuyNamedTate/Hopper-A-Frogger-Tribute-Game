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
 * @author C0433873
 */
public class Outback extends GameObject {
    
    
    public ImageIcon outback = new ImageIcon(this.getClass().getResource("outback.png"));
    
    public Outback(int x, int y, ID id) {
        super(x, y, id);
        
    }
    
    public void tick() {

    }
    
    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.green);
        //g.fillRect((int) x, (int) y, 32, 32);
        outback.paintIcon(null, g,(int) x,(int) y);

    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }
    
}