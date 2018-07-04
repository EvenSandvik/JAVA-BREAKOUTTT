package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;

public class PowerUpPlatformSize {

	int x, y;
	Ball b;
	Player p;
	Breakout game;
		public PowerUpPlatformSize(Ball b, Player p, Breakout game){
		this.b = b;
		this.p = p;
		Random spawnPowerUp = new Random();
		x = spawnPowerUp.nextInt(800) + 50;
		y = spawnPowerUp.nextInt(400) + 100;
		this.game = game;
	}
	
	
	public void draw(Graphics g){
		g.setColor(Color.pink);
		g.drawOval(x, y, 100, 100);
		if(b.checkCollision(x, y, 100, 100)){
			//TODO: bug where everything stops at deletePowerUp();
			//game.deletePowerUp();
			if(p.getWidth()<100)
			p.setWidth(15);
		}
		
	}
	
}
