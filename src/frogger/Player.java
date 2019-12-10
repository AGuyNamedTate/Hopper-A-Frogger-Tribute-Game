package frogger;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import frogger.ID;
import static frogger.ID.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import frogger.BasicEnemy;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author TateM
 */
public class Player extends GameObject {

    //Player Player = new Player((int)x,(int)y,id.Player);
    //BasicEnemy Enemy = new BasicEnemy((int)x,(int)y,id.Enemy,0.28);
    Random r = new Random();
    Handler handler;
    HUD hud;
    WinCondition w;
    Death d;

    private int bottom = 30;
    private int right = 30;
    public ImageIcon player = new ImageIcon(this.getClass().getResource("kangaroo1.png"));
    public ImageIcon playerAlt = new ImageIcon(this.getClass().getResource("kangaroo2.png"));

    BasicEnemy other;
    public int joeyCount = 0;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    //  @Override
    public void tick() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //this is so my objects move
        x += velX;
        y += velY;

        x = Frogger.clamp((int) x, 0, Frogger.WIDTH - 38);
        y = Frogger.clamp((int) y, 88, Frogger.HEIGHT - 72);

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            GameObject tempObject2 = handler.object.get(i);

            if (tempObject.getId() == ID.Enemy || tempObject.getId() == ID.Bus) {
                if (getBounds().intersects(tempObject.getBounds())) {

                    HUD.HEALTH = 0;
                    death(dead(HUD.HEALTH));
                }
            } else if (tempObject.getId() == ID.Bike) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 50;
                    handler.removeObject(handler.object.get(i));

                    death(dead(HUD.HEALTH));
                }
            } else if (tempObject.getId() == ID.Joey) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (this.joeyCount < 2) {
                        handler.removeObject(handler.object.get(i));
                        //playSound("Sounds/boing.wav");
                        this.joeyCount++;
                        System.out.println("Joey Count: " + this.joeyCount);
                    }

                }
            } else if (tempObject.getId() == ID.Bush) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    joeyCount = 0;
                    youWin(win());

                }
            }/*else if(tempObject.getId()==ID.Log){
                if(getBounds().intersects(tempObject.getBounds())){
                    velX = 0.5f;
                }
            }else if(tempObject.getId()==ID.MudPit){
                if(getBounds().intersects(tempObject.getBounds())){
                   // HUD.HEALTH=0;
                    death(dead(HUD.HEALTH));
                }
            }*/
        }
    }

    // @Override
    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //for multiplayer use the if statement below
        if (id == ID.Player) {
            //my player and their color
            g.setColor(Color.white);
            //g.fillRect((int) x, (int) y, right, bottom);
            player.paintIcon(null, g, (int) x, (int) y);
        }/* else if (id == ID.Player2) {
         g.setColor(Color.blue);
         g.fillRect(x, y, 32, 32); 
         }*/

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 32);
    }

    public boolean dead(int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void death(boolean ded) {

        if (ded) {
            handler.addObject(new Death(0, 0, ID.Death));
            System.out.println("YOU ARE DEAD");
        }

    }

    public boolean win() {

        boolean condition = false;
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Joey) {
                i = handler.object.size();
                condition = false;
            } else if (tempObject.getId() != ID.Joey) {
                condition = true;
            }
        }
        return condition;
    }

    public void youWin(boolean w) {
        if (w) {
            handler.addObject(new WinCondition(0, 0, ID.Win));
        }
    }

    /*public void playSound(String filepath){
        
        //InputStream sound;

        try{
            Clip clip = AudioSystem.getClip();
                        System.out.println("check");

            AudioInputStream stream = AudioSystem.getAudioInputStream(getResourceAsStream(filepath));
            clip.open(stream);
            clip.start();
            //sound = new FileInputStream(new File(filepath));
            //AudioStream audio = new AudioStream(sound);
            //AudioPlayer.player.start(sound);
        }
        catch(Exception e){
            System.out.println("no");
        }
    
    }*/
}
