package frogger;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author TateM
 */
public class HUD {
    
    public static int HEALTH = 100;

    Player me;
    
    public int greenVal = 255;
    public int count;
    
    
    
    public void tick() {
        HEALTH = Frogger.clamp(HEALTH, 0, 100);
        greenVal = Frogger.clamp(greenVal, 0, 255);
        greenVal = HEALTH * 2;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 22, 200, 32);
        g.setColor(new Color(100, greenVal, 0));
        g.fillRect(15, 22, HEALTH * 2, 32);
        g.drawRect(15, 22, 200, 32);
        g.setColor(Color.white);
        g.drawString("Joey Count: x", 218, 32);
        g.drawString("Fun Fact: Kagaroo mothers generally carry 2 Joeys at most", 300,32);
        g.setFont(g.getFont().deriveFont(18.0f));
        g.drawString("Health: " + HEALTH, 218, 48);
        
    }
    
}
