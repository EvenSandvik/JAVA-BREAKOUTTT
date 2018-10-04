package Blocks;

import java.util.Random;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;
//Spawns an extra ball
public class PowerUpExtraBall extends AbstractPowerUp {
	public PowerUpExtraBall(Ball b, Player p, Breakout game){
		this.ball = b;
		this.player = p;
		Random spawnPowerUp = new Random();
		x = spawnPowerUp.nextInt(800) + 50;
		y = spawnPowerUp.nextInt(400) + 100;
		this.game = game;
	}
	
}
