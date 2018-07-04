/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author herms97
 */
public class Player{
    
    float speed = 0;
    float x = 450;
    final float y = 500;
    int points = 0;
    
    Player(int x, int y){
    }
    
    int width = 150;
    int height = 20;
    
    public void setWidth(int grow){
    	
    	width = width + grow;
    	
    }
    
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect((int) x, (int)y, width, 20);
        
    }
    public void move(){
        //(x > 0 && x < 1000)
        if(x < 0)
            x = 0;
        else if(x > 1000-width)
            x = 1000-width;
        else
            x += speed;

        
    }
    
    
    public float getX(){
        
        return x;
    }
    
    public float getY(){
        
        return y;
    }
    
    public int getWidth(){
        
        return width;
    }
    
    public int getHeight(){
        
        return height;
    }
    
    public int getPoints(){  
        return points;
    }
    public void setPoint(int points){
		this.points += points;
	}

    public void keyPressed(KeyEvent e, int VKleft, int VKright) {
                if(e.getKeyCode() == VKleft){
                        speed = -8;
                        
		}
                
                if(e.getKeyCode() == VKright){
                    speed = 8;
                }
    }

    public void keyReleased(KeyEvent e, int VKleft, int VKright) {
                if(e.getKeyCode() == VKleft || e.getKeyCode() == VKright){
                        speed = 0;
		}
    }
}
