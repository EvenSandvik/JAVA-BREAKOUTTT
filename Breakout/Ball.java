package Breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Ball {
	static float x;
    static float velocity = 2;
	static float xVel = 0;
	static float y;
	static float yVel = -3;
	public int hitPlayer = 0;
	static Breakout game;
	float ballHitPlayer;
	float center;
	static boolean collision = true;
	static Image ballImg;
	static boolean gravity = false;
	static int temp = 0;

        
	Player p;
	
	Ball(float x, float y, Player p, Breakout game){
		this.x = x;
		this.y = y;
		this.p = p;
		this.game = game;
	}
	
	//calculates how the ball bounces off Player
		private void bounceBack(Player p){
				center = p.getX() + (p.getWidth()*0.5f);
				ballHitPlayer = x-center;
				
				if(!(ballHitPlayer < 75 && ballHitPlayer > -75)){
					if(ballHitPlayer<0)
						ballHitPlayer = -75;
					else ballHitPlayer = 75;
				}
					
				xVel = (float) Math.sin(Math.toRadians(ballHitPlayer)) * velocity;
	            yVel = (float) Math.cos(Math.toRadians(ballHitPlayer)) * velocity;
	            
	            //always make ball go up
	            if(yVel>0)yVel = -yVel;
	            
	            //System.out.println("BallHit: " + ballHitPlayer + " x: " + xVel + " y: " + yVel + " velocity: " + velocity);
		}
		
	 public boolean checkCollision(int x, int y, int width, int height){
     	if(this.y >= y && this.y<= y + height){
     		if(this.x >= x && this.x <= x + width){
     			return true;
     		}
     		
     	}
     	return false;
     }

	public void checkCollision(Player p){
         if(y >= p.getY() - 20 && y <= p.getY() + p.getHeight()){
             if(x+20 >= p.getX() && x <= p.getX() + p.getWidth()){
             	collision = true;
                 bounceBack(p);
                 if(collision)
                 	moveBallPlayerHit(p);
             }
         }
     }
	 
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int) x, (int)y, 20, 20);
	}
	
	public boolean getCollision(){
		return collision;
	}

	public float getxVel(){       
		return xVel;
    }
	
    public float getyVel(){       
    		return yVel;
    }
    
	public float getVelocity(){
		return velocity;
	}
	
  public float getX(){       
		return x;
	}

	public float getY(){       
		return y;
}

	//Moves the x and y with xVel and yVel
  	public static void move(){
  		if(velocity < 3.5)
  			velocity += 0.00001f;
  		x += xVel*velocity;
  		y += yVel*velocity;
  		if(gravity)
  		{
  			yVel += 0.01; //gravitasjon
  			temp++;
  			if(temp==3000)
  			{
  				temp = 0;
  				gravity = false;
  			}
  		}
  		if(x>=880 || x<=0){
  			xVel = -xVel;
  			if(x>=880) x=880;
  			else if(x<=0) x=0;
  		}
  			
  		
  		if(y<0){
  			yVel = -yVel;
  			y=0;
  		}
  	}

  		public void moveBallPlayerHit(Player p) {
  			if(y>p.getY()){ 
  				y = p.getY()-21;
  			}
  			hitPlayer++;
  			if(hitPlayer == 8){
  				game.moveBlocksDown();
  				hitPlayer = 0;
  			}
  			collision = false;
  		}
  		
  		public void moveBallToStart(){
  			x=300;
  			y=300;
  		}

	public void setVelocity(int i) 
	{
		velocity = i;
	}
	public void setxVel(float f)
	{
		xVel = f;
	}
	
	public void setyVel(float y)
	{
		yVel = y;
	}
	public void setGravity(boolean t){
		gravity = t;
	}
        
}
