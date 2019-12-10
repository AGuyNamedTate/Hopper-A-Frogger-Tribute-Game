package frogger;

import frogger.ID;
import frogger.Lane;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import javax.imageio.ImageIO;


/**
 *
 * @author TateM
 */
public class BasicEnemy extends GameObject{
    
    static Random r = new Random();

    public int right;
    public int bottom = 30;
    public static int direct =1;
    
    public ImageIcon bike1 = new ImageIcon(this.getClass().getResource("bike1.png"));
    public ImageIcon bus1 = new ImageIcon(this.getClass().getResource("bus.png"));
    public ImageIcon car1 = new ImageIcon(this.getClass().getResource("car1.png"));
    public ImageIcon bike2 = new ImageIcon(this.getClass().getResource("bike2.png"));
    public ImageIcon busLeft = new ImageIcon(this.getClass().getResource("busLeft.png"));
    public ImageIcon carLeft = new ImageIcon(this.getClass().getResource("carLeft.png"));
    public ImageIcon bike1Left = new ImageIcon(this.getClass().getResource("bike1Left.png"));
    public ImageIcon bike2Left = new ImageIcon(this.getClass().getResource("bike2Left.png"));

    public BasicEnemy(int x, int y, ID id, float speed) {
        super(x, y, id);
        velX = speed;//*getDirection();
    }

    //@Override
    public void tick() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x += velX;
        JFrame j = new JFrame();

        if (x > 715) {
            x = 0 - right;

        }else if(x<-76){
            x= 714;
        }
        /*if(right < Frogger.WIDTH - right){
         x = Frogger.WIDTH+x;
         }*/
    }

    //@Override
    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if (id == ID.Enemy) {

           if(this.velX<0){
                g.setColor(Color.red);
                right = 50;
                //g.fillRect((int) x, (int) y, right, bottom);
                carLeft.paintIcon(null, g,(int) x,(int) y);
            }else if(this.velX>0){
                g.setColor(Color.red);
                right = 50;
                //g.fillRect((int) x, (int) y, right, bottom);
                car1.paintIcon(null, g,(int) x,(int) y);
            
            }
            
            
        } else if (id == ID.Bus) {
            if(this.velX<0){
                g.setColor(Color.blue);
                right = 75;
                //g.fillRect((int) x, (int) y, right, bottom);
                busLeft.paintIcon(null, g,(int) x,(int) y);
            }else if(this.velX>0){
                g.setColor(Color.blue);
                right = 75;
                //g.fillRect((int) x, (int) y, right, bottom);
                bus1.paintIcon(null, g,(int) x,(int) y);;
            
            }

            

        } else if (id == ID.Bike) {
            if(this.velX<0){
                g.setColor(Color.yellow);
                right = 32;
                //g.fillRect((int)x,(int)y,right,bottom);
                bike1Left.paintIcon(null, g,(int) x,(int) y);
            }else if(this.velX>0){
                g.setColor(Color.yellow);
                right = 32;
                //g.fillRect((int)x,(int)y,right,bottom);
                bike1.paintIcon(null, g,(int) x,(int) y);
            
            }

        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, right, 32);
    }
    
    
}
