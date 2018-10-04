package Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Breakout.Ball;
import Breakout.Breakout;
import Breakout.Player;
/**
 * 
 * @author Even Berge Sandvik
 * Class contains implementations useful for PowerUps
 */
public class AbstractPowerUp {
	int x, y;
	int size = 30;
	Ball ball;
	Player player;
	Breakout game;
	Image powerImg;
	
	public void turnOnGravity(){
		ball.setGravity(true);
	}
	//spaghetti code
	public void removePowerUp(){
		size = 0;
	}
	public void draw() {
		// TODO draw metodene under
		
	}
}
