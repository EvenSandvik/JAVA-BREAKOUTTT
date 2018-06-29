package Breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	static float x;
	static float xVel = 10f;
	static float y;
	static float yVel = 5f;
	public void Ball(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	//Moves the x and y with xVel and yVel
	public static void move(){
		x += xVel;
		y += yVel;
		if(x>=1000 || x<=0)
			xVel = -xVel;
		if(y>600 || y<0)
			yVel = -yVel;
	}
	
	//calculates how the ball bounces off Player
	public void bounceBack(){
		//
	}
	
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int)y, 20, 20);
	}
}
