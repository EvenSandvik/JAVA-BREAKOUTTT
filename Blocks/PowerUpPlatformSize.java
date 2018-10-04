package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;

public class PowerUpPlatformSize extends AbstractPowerUp {
	
		public PowerUpPlatformSize(Ball b, Player p, Breakout game){
		this.ball = b;
		this.player = p;
		Random spawnPowerUp = new Random();
		x = spawnPowerUp.nextInt(800) + 50;
		y = spawnPowerUp.nextInt(400) + 100;
		this.game = game;
	}
		
		public void draw(Graphics g){
			g.setColor(Color.pink);
			g.fillRect(x, y, size, size);
			//game.drawImageBreakout("powerUpSize.png", powerImg, x, y);
			if(ball.checkCollision(x, y, size, size)){
				if(player.getWidth()<100)
					player.growWidth(15);
				removePowerUp();
			}
		}
		
}
