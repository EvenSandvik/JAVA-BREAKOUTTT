package newpackage;

import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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
	
	//TODO: Herman fixi. Skriv metoden for player
	Player player = new Player(450, 300);
	
	//TODO: Ball klasse. Heems eller evvs fix
	Ball ball = new Ball(500, 0);
	
	//Method initializes application
	public void init(){
		this.addKeyListener(this);
		this.resize(WIDTH, HEIGHT);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}
        
        public void startGame(){
            gameStarted = true;
        }
        
        public void gameOver(){
                gameStarted = false;
                ball = new Ball(500, 0);
                player = new Player(450, 300); 
        }
	//Updates per cycle
	public void update(Graphics gfx){
            if(gameStarted){
		Ball.move();
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
                gfx.drawString("Points: " + ball.getPoints(), 0, 600 );
		
                player.draw(gfx);
		g.drawImage(img, 0, 0, this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//Det som skjer n�r du trykke ENTER
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
