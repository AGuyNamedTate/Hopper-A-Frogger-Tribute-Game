package frogger;

import frogger.ID;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author TateM
 */
public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY;
    final protected int HEIGHT = 32;
    protected int right;
    
    protected float ox, oy;
    protected float oRight;
    final protected float oHEIGHT = oy - 32;
    
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = this.x + x;
    }

    public void setY(int y) {
        this.y = this.y + y;

    }

    public float getX() {
        return this.x;

    }

    public float getY() {
        return this.y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;

    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;

    }

    public float getVelX() {
        return this.velX;
    }

    public float getVelY() {
        return this.velY;
    }
    
    public abstract Rectangle getBounds();
    
}
