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
public class Log extends GameObject{
        
    Handler handler;
    
    float speed = -0.5f;
    
    public ImageIcon log = new ImageIcon(this.getClass().getResource("log.png"));
    
    public Log(int x, int y, ID id) {
        super(x, y, id);

        velX = speed;
        
    }
    
    public void tick() {

        x+=velX;
        
        if (x > 715) {
            x = 0 - right;

        }else if(x<-76){
            x= 714;
        }
    }
    
    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //g.setColor(Color.green);
        //g.fillRect((int) x, (int) y, 32, 32);
        log.paintIcon(null, g,(int) x,(int) y);

    }
    


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 50, 32);
    }
    
}

