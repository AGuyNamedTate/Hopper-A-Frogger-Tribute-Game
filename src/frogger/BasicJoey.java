/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import frogger.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TateM
 */
public class BasicJoey extends GameObject {

    public int joeyCount;
    
    Handler handler;
    
     public ImageIcon joey = new ImageIcon(this.getClass().getResource("joey.png"));

    public BasicJoey(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        
    }

    //@Override
    public void tick() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x += velX;
        y += velY;


        if (x >= Frogger.WIDTH ) {
            x = -32;
        }

        collision();
    }

    //@Override
    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.green);
        //g.fillRect((int) x, (int) y, 32, 32);
        joey.paintIcon(null, g,(int) x,(int) y);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 30);
    }
    
    public void collision() {
       
        for(int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.MudPit){
                if (getBounds().intersects(tempObject.getBounds())) {
                    velX = 1;
                    //System.out.println("Yeep");
                }
            }
        }
    }
}
