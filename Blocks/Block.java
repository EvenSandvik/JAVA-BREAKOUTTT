package Blocks;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public void blockCheckHit(){
		if(checkCollision()){
			b.setxVel(-b.getxVel());
			b.setyVel(-b.getyVel());
			hits--;
		}
	}
	
	public void draw(Graphics g){
		if(hits == 5){
			g.setColor(Color.blue);
		}
		else if(hits == 4){
			g.setColor(Color.green);
		}
		else if(hits == 3){
			g.setColor(Color.yellow);
		}
		else if(hits == 2){
			g.setColor(Color.red);
		}
		else if(hits == 1){
			g.setColor(Color.white);
		}
		else{
			//TODO: destroy object
			game.delete(this);
		}
        
        g.fillRect((int) x, (int)y, width, height);
        
    }
}
