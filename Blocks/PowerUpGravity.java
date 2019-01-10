package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;

public class PowerUpGravity extends AbstractPowerUp{
	
	public PowerUpGravity(Ball b, Player p, Breakout game){
		this.ball = b;
		this.player = p;
		Random spawnPowerUp = new Random();
		x = spawnPowerUp.nextInt(800) + 50;
		y = spawnPowerUp.nextInt(400) + 100;
		this.game = game;
	}

	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, size, size);
		//game.drawImageBreakout("powerUpSize.png", powerImg, x, y);
		if(ball.checkCollision(x, y, size, size)){
			turnOnGravity();
			removePowerUp();
		}
	}
}
