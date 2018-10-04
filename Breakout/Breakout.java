package Breakout;

import java.applet.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import Blocks.AbstractPowerUp;
import Blocks.Block;
import Blocks.PowerUpGravity;
import Blocks.PowerUpPlatformSize;


/**README
 * https://www.ludumdare.com/compo/wp-content/uploads/2012/08/breakout_clone-550x733.png
 * Senere bytt Applet til Swing?
 */

public class Breakout extends Applet implements Runnable, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int WIDTH = 900, HEIGHT = 900; 
    float blockHeight = 0;
	int i, j;
	int lives = 3;
	int points = 0;
    boolean gameStarted, gameOver = false;
    
    Thread thread;
	Graphics gfx;
    ArrayList<Block> blocks = new ArrayList<Block>();
    ArrayList<AbstractPowerUp> powerUps = new ArrayList<AbstractPowerUp>();
	Player player = new Player();
	Ball ball = new Ball(400, 600, player, this);
	Image img;
	Image playerImg;
	Random rand = new Random();
	
	PowerUpPlatformSize powerUp = new PowerUpPlatformSize(ball, player, this);
	PowerUpGravity powerUp2 = new PowerUpGravity(ball, player, this);
    
    //TODO kan spawne på samme posisjon
    private void blockGenerator(){
    	//random gange 50.  1...18*50
    	for(int diffic = 0; diffic<18; diffic++){
    		i = rand.nextInt(18) + 0;
    		j = rand.nextInt(4) + 1;
    		blocks.add(new Block(i*50,-20+blockHeight%20,j,ball,player,this));
    	}
    }

	public void delete(Block b){
		for(i = 0; i<blocks.size(); i++){
			if(b.equals(blocks.get(i))){
				blocks.remove(i);
				points += 50;
			}
		}
	}
	
	public void drawImageBreakout(String Image, Image blockImage, float x, float y){
		blockImage = getImage(getCodeBase(), Image);
		gfx.drawImage(blockImage, (int) x, (int) y, this);
	}
    
	//Method initializes application
	public void init(){
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		
		setBlocks();
		this.addKeyListener(this);
		this.resize(WIDTH, HEIGHT);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(!gameOver){
			gameStarted = !gameStarted;
			}
			else{
				lives = 3;
				points = 0;
				gameOver = false;//redundant? i think so
				gameStarted = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_H){
			Ball.y = 100;
		}
		if(e.getKeyCode() == KeyEvent.VK_J){
			ball.hitPlayer = 7;
			ball.moveBallPlayerHit(player);
		}
                player.keyPressed(e, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//Det som skjer nï¿½r du trykke ENTER
		}
                player.keyReleased(e, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    public void moveBlocksDown(){
        for(i = 0; i<blocks.size(); i++)
        	((Block) blocks.get(i)).addToY(20);
        blockHeight += 20;
        blockGenerator();
    }
    
	public void paint(Graphics g){
		
		Font font = new Font("helvetica", Font.BOLD, 30);
		gfx.setFont(font);
		
		gfx.setColor(new Color(169,169,169));
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		for(i = 0; i<blocks.size(); i++)
        	((Block) blocks.get(i)).draw(gfx);
        	i=0;
		gfx.setColor(Color.white);
		if(lives<1){
			setGameOver();
		}
		else if(!gameStarted)
        	gfx.drawString("Press enter to begin", 320, 300);
		Ball.draw(gfx);
        gfx.drawString("Score: " + points, 0, 680 );
        gfx.drawString("Lives: " + lives, 700, 680 );
        //morsom glitch under
        //gfx.drawImage(img, 150, 20, this);
        powerUp.draw(gfx);
        powerUp2.draw(gfx);
		
		playerImg = getImage(getCodeBase(), "playerImage.jpg");
		gfx.drawImage(playerImg, (int) player.getX(), (int) player.getY(), this);
		g.drawImage(img, 0, 0, this);
		
	}
	//TODO: not working
	private void powerUpGenerator(){
		spawnPowerUp(1);
	}
	
	@Override
	public void run() {
		while(true){
			repaint();
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        
		}
	}
	
	 private void resetBall(){
	        gameStarted = false;
	        ball = new Ball(400, 600, player, this);
	        ball.setxVel(0);
	        ball.setyVel(-3);
	        ball.setVelocity(2);
	        player = new Player();
	    }
	 
	 private void spawnPowerUp(int integer){
		 if(integer==0){
			 powerUps.add(new PowerUpPlatformSize(ball, player, this)); 
		 }
		 if(integer==1){
			 powerUps.add(new PowerUpGravity(ball, player, this)); 
		 }
	 }
	 	//Ugly method for setting first 36 bricks
        private void setBlocks() {
		blocks.add(new Block(0,80,5,ball, player, this));
		blocks.add(new Block(100,80,5,ball, player, this));
		blocks.add(new Block(200,80,5,ball, player, this));
		blocks.add(new Block(300,80,5,ball, player, this));
		blocks.add(new Block(400,80,5,ball, player, this));
		blocks.add(new Block(500,80,5,ball, player, this));
		blocks.add(new Block(600,80,5,ball, player, this));
		blocks.add(new Block(700,80,5,ball, player, this));
		blocks.add(new Block(800,80,5,ball, player, this));
		
		blocks.add(new Block(50,80,5,ball, player, this));
		blocks.add(new Block(150,80,5,ball, player, this));
		blocks.add(new Block(250,80,5,ball, player, this));
		blocks.add(new Block(350,80,5,ball, player, this));
		blocks.add(new Block(450,80,5,ball, player, this));
		blocks.add(new Block(550,80,5,ball, player, this));
		blocks.add(new Block(650,80,5,ball, player, this));
		blocks.add(new Block(750,80,5,ball, player, this));
		blocks.add(new Block(850,80,5,ball, player, this));
		
		blocks.add(new Block(0,100,5,ball, player, this));
		blocks.add(new Block(100,100,5,ball, player, this));
		blocks.add(new Block(200,100,5,ball, player, this));
		blocks.add(new Block(300,100,5,ball, player, this));
		blocks.add(new Block(400,100,5,ball, player, this));
		blocks.add(new Block(500,100,5,ball, player, this));
		blocks.add(new Block(600,100,5,ball, player, this));
		blocks.add(new Block(700,100,5,ball, player, this));
		blocks.add(new Block(800,100,5,ball, player, this));
		
		blocks.add(new Block(50,100,5,ball, player, this));
		blocks.add(new Block(150,100,5,ball, player, this));
		blocks.add(new Block(250,100,5,ball, player, this));
		blocks.add(new Block(350,100,5,ball, player, this));
		blocks.add(new Block(450,100,5,ball, player, this));
		blocks.add(new Block(550,100,5,ball, player, this));
		blocks.add(new Block(650,100,5,ball, player, this));
		blocks.add(new Block(750,100,5,ball, player, this));
		blocks.add(new Block(850,100,5,ball, player, this));
	}

        //TODO finish
        public void setGameOver(){
        	gameOver = true;
			gfx.setColor(Color.RED);
    		gfx.drawString("GAME OVER", 360, 300);
    		gfx.setColor(Color.WHITE);
    		gfx.drawString("Your total score: " + points, 320, 400);
        }
        
	//Updates per cycle
	public void update(Graphics gfx){
            if(gameStarted){
            	//gradually increase points
            	if(j>50){
            		points++;
            		j=0;
            	}
            	j++;
            	
            	Ball.move();
            	//check collisions for blocks with ball
            	for(i = 0; i<blocks.size(); i++)
            	((Block) blocks.get(i)).blockCheckHit();
            	i=0;
            	
                ball.checkCollision(player);            
                player.move(); 
                if(ball.getY()>=770){
                	lives--;
                	resetBall();
                }
                
                if(true){
                	powerUpGenerator();
                }
                for(int index = 0; index < powerUps.size(); index++){
                	powerUps.get(index).draw();
                }
            }
                paint(gfx);
	}
	
}
