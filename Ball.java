package newpackage;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	static float x;
        static float velocity = 1;
	static float xVel = 2;
	static float y;
	static float yVel = 2;
        int points = 0;

        
	Ball(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	//Moves the x and y with xVel and yVel
	public static void move(){
                velocity += 0.001f;
                System.out.println(velocity);
		x += xVel*velocity;
		y += yVel*velocity;
		if(x>=1000 || x<=0)
			xVel = -xVel;
		if(y<0)
			yVel = -yVel;
	}
	
        
        
        public void checkCollision(Player p){
            if(y >= p.getY() - 20 && y <= p.getY() + p.getHeight()){
                if(x >= p.getX() && x < p.getX() + p.getWidth()){
                    yVel = -yVel;
                    points += 10;
                    //bounceBack(p);
                }
            }
        }
        
        
        public int getPoints(){
            
            return points;
        }
        
	//calculates how the ball bounces off Player
	public void bounceBack(Player p){
            
            float center = p.getX() + (p.getWidth()*0.5f);
            xVel = (float) Math.cos(center) * velocity;
            yVel = (float) Math.sin(center) * velocity;
	}
	
        public float getY(){
            
            return y;
        }
        
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int)y, 20, 20);
	}
        
}
