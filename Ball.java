package Breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	static float x;
         static float velocity = 2;
	static float xVel = 2;
	static float y;
	static float yVel = 2;

        
	Player p;
	
	Ball(float x, float y, Player p){
		this.x = x;
		this.y = y;
		this.p = p;
	}
	
	//Moves the x and y with xVel and yVel
	public static void move(){
        velocity += 0.0003f;
		x += xVel*velocity;
		y += yVel*velocity;
		if(x>=980 || x<=0)
			xVel = -xVel;
		if(y<0)
			yVel = -yVel;
	}
	
        
        
        public void checkCollision(Player p){
            if(y >= p.getY() - 20 && y <= p.getY() + p.getHeight()){
                if(x >= p.getX() && x <= p.getX() + p.getWidth()){
                    //yVel = -yVel;
                    bounceBack(p);
                }
            }
        }
        
        public boolean checkCollision(int x, int y, int width, int height){
        	
        	if(this.y >= y && this.y<= y + height){
        		if(this.x >= x && this.x <= x + width){
        			return true;
        		}
        		
        	}
        	return false;
        }
        
        
 
	//calculates how the ball bounces off Player
	private void bounceBack(Player p){
            
            //float center = p.getX() + (p.getWidth()*0.5f);
			float center = p.getX() + (p.getWidth()*0.5f);
			float ballHitPlayer = center-x;
			
            xVel = (float) Math.sin(ballHitPlayer) * velocity;
            yVel = (float) Math.cos(ballHitPlayer) * velocity;
            
            //always make ball go up
            if(yVel>0)yVel = -yVel;
	}
	public void bounceBack(){
		yVel = -yVel;
	}
	
	public float getX(){       
		return x;
    }
	
    public float getY(){       
    		return y;
    }
    public float getxVel(){       
		return xVel;
    }
	
    public float getyVel(){       
    		return yVel;
    }
        
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int) x, (int)y, 20, 20);
	}

	public void setVelocity(int i) {
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
	
        
}
