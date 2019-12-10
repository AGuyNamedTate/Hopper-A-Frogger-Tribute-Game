/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import static frogger.Frogger.WIDTH;
import static frogger.Frogger.running;
import frogger.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import frogger.BasicEnemy;
import frogger.Handler;
import java.awt.Rectangle;

/**
 *
 * @author C0433873
 */
public class Lane extends GameObject {

    private Handler handler;

    Random r = new Random(3);

    public Lane(int x, int y, ID id) {
        super(x, y, id);

    }

    public void tick() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public void render(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.gray);
        g.fillRect((int) x, (int) y, 700, 31);
        //g.setColor(Color.black);
        //g.drawLine(0, (int)y, 640, (int)y);

    }

    public Rectangle getBounds() {

        return null;
    }
}
