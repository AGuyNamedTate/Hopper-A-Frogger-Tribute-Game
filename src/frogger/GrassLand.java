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
public class GrassLand extends GameObject{
    
    public ImageIcon grass = new ImageIcon(this.getClass().getResource("grassland.png"));
    
    public GrassLand(int x, int y, ID id){
        super(x,y,id);
    }
    
    public void tick(){
        
    }
    public void render(Graphics g){
        
        grass.paintIcon(null, g,(int) x,(int) y);
    }
    
    public Rectangle getBounds(){
        return null;
    }
}
