package GUI;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import Breakout.Breakout;

public class MainMenu extends Applet implements MouseInputListener{
	final int WIDTH = 1000, HEIGHT = 600;
	Graphics gfx;
	Image img;
	Image playerImg;
	
	public void init(){
		this.resize(WIDTH, HEIGHT);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		this.addMouseListener(this);
	}
	
	public void Update(Graphics g){
		paint(gfx);
	}
	
	public void paint(Graphics g){
		
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.setColor(Color.white);
		gfx.drawString("Press to Play", 500, 300);
		playerImg = getImage(getCodeBase(), "playerImage.jpg");
		g.drawImage(img, 0, 0, this);
		g.drawImage(playerImg, 0, 0, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Make it start the game
		if(e.getX() >= 500 && e.getX() <= 600){
			if(e.getY() >= 300 && e.getY() <= 350){
				Breakout game = new Breakout();
				System.out.println("#MainMenu mouseclicked()");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
