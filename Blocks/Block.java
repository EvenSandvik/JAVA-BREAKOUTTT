package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;

public class Block {
	float x, y;
	int hits;
	int width = 50;
	int height = 20;
	Ball b;
	Player p;
	Breakout game;
	Image blockImg;
	
	public Block(float x, float y, int hits, Ball b , Player p, Breakout game){
		this.x = x;
		this.y = y;
		this.hits = hits;
		this.b = b;
		this.p = p;
		this.game = game;
	}
	
	//TODO: bruk den i ball senere heller. EZ
	public boolean checkCollision(){
	// fyll inn b.checkCollision();
		if(x <= b.getX()+20 && (x + width) >= b.getX()+20){
			if(y <= b.getY()+20 && (y + width) >= b.getY()+20){
				return true;
			}
		}
		return false;
	}
	
	public void setHits(int hits){
		this.hits = hits;
	}
	//TODO: lag helt korrekt
	public void blockCheckHit(){
		if(checkCollision()){
			if(b.getY() < y || b.getY() > y+height)
				b.setyVel(-b.getyVel());
			else
				b.setxVel(-b.getxVel());
				
			hits--;
		}
	}
	
	public void draw(Graphics g){
		if(y>600)
		{
			game.setGameOver();
		}
		if(hits == 5){
			//g.setColor(Color.blue);
			game.drawImageBreakout("block5.png", blockImg, x, y);
		}
		else if(hits == 4){
			//g.setColor(Color.green);
			game.drawImageBreakout("block4.png", blockImg, x, y);
		}
		else if(hits == 3){
			//g.setColor(Color.yellow);
			game.drawImageBreakout("block3.png", blockImg, x, y);
		}
		else if(hits == 2){
			//g.setColor(Color.red);
			game.drawImageBreakout("block2.png", blockImg, x, y);
		}
		else if(hits == 1){
			//g.setColor(Color.white);
			game.drawImageBreakout("block1.png", blockImg, x, y);
		}
		else{
			game.delete(this);
		}
        
        //g.fillRect((int) x, (int)y, width, height);
        
    }
	public void addToY(float y){
		this.y += y;
		
	}
}
