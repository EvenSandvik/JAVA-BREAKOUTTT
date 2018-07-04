package Breakout;

import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import Blocks.Block;
import Blocks.PowerUpPlatformSize;


/**README
 * https://www.ludumdare.com/compo/wp-content/uploads/2012/08/breakout_clone-550x733.png
 * Senere bytt Applet til Swing?
 */

public class Breakout extends Applet implements Runnable, KeyListener {
	Thread thread;
	Graphics gfx;
	final int WIDTH = 1000, HEIGHT = 600; 
	Image img;
    boolean gameStarted = false;
    int i;
    ArrayList blocks = new ArrayList();
	Player player = new Player(450, 300);
	Ball ball = new Ball(500, 0, player);
	Image playerImg;
	
	PowerUpPlatformSize powerUp = new PowerUpPlatformSize(ball, player, this);
    
   
    
	//Method initializes application
	public void init(){
		setBlocks();
		this.addKeyListener(this);
		this.resize(WIDTH, HEIGHT);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}
        
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
		blocks.add(new Block(900,80,5,ball, player, this));
		
	}

		public void startGame(){
            gameStarted = true;
        }
        
        public void gameOver(){
                gameStarted = false;
                ball = new Ball(500, 0, player);
                ball.setVelocity(1);
                player = new Player(450, 300); 
        }
	//Updates per cycle
	public void update(Graphics gfx){
            if(gameStarted){
            	Ball.move();
            	//check collisions for blocks with ball
            	for(i = 0; i<blocks.size(); i++)
            	((Block) blocks.get(i)).blockCheckHit();
            	i=0;
            	
                ball.checkCollision(player);                
                player.move(); 
                if(ball.getY()>=600)
                    gameOver();
            }
                paint(gfx);

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
	
	public void paint(Graphics g){
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.setColor(Color.white);
        if(!gameStarted)
        	gfx.drawString("Press enter to begin", 460, 300);
		Ball.draw(gfx);
        gfx.drawString("Points: " + player.getPoints(), 0, 600 );
        //player.draw(gfx);
        //img = getImage(getCodeBase(), "playerImage.jpg");
        //morsom glitch under
        //gfx.drawImage(img, 150, 20, this);
        powerUp.draw(gfx);
        
        for(i = 0; i<blocks.size(); i++)
        	((Block) blocks.get(i)).draw(gfx);
        	i=0;
        
		g.drawImage(img, 0, 0, this);
		playerImg = getImage(getCodeBase(), "playerImage.jpg");
		g.drawImage(playerImg, (int) player.getX(), (int) player.getY(), this);
		
	}
	
	public void delete(Block b){
		for(i = 0; i<blocks.size(); i++){
			if(b.equals(blocks.get(i))){
				blocks.remove(i);
				player.setPoint(50);
			}
		}
	}
	//make more general use if possible
	public void deletePowerUp(){
		powerUp = null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//Det som skjer naar du trykke ENTER
		}
                player.keyPressed(e, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    startGame();
			//Det som skjer n�r du trykke ENTER
		}
                player.keyReleased(e, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
