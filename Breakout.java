package Breakout;

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
	
	//TODO: Herman fixi. Skriv metoden for player
	//Player player = new Player();
	
	//TODO: Ball metode. Heems eller evvs fix
	//Ball ball = new Ball();
	
	//Method initializes application
	public void init(){
		this.addKeyListener(this);
		this.resize(WIDTH, HEIGHT);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}
	//Updates per cycle
	public void update(Graphics gfx){
		paint(gfx);
	}
	
	@Override
	public void run() {
		while(true){
			repaint();
		}
	}
	
	public void paint(Graphics g){
		gfx.setColor(Color.GREEN);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.setColor(Color.black);
		gfx.drawString("TEST TEST TEST TEST TEST", 340, 30);
		//draw ball, player etc...
		
		g.drawImage(img, 0, 0, this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//Det som skjer når du trykke ENTER
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
