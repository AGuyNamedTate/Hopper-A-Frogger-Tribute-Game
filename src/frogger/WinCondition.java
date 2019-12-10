package frogger;

import frogger.Handler;
import frogger.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TateM
 */
public class WinCondition extends GameObject {

    public Handler handler;

    public WinCondition(int x, int y, ID id) {
        super(x, y, id);
    }

    

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 640);
        g.setColor(Color.green);
        g.setFont(g.getFont().deriveFont(56.0f));
        g.drawString("You Win", 56, 320);
    }

    public Rectangle getBounds() {
        return null;
    }

}
