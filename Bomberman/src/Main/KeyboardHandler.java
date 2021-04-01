package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entity.Player;

public class KeyboardHandler implements KeyListener {
	Player bomber;
	public KeyboardHandler(Player bomber){
		this.bomber=bomber;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			bomber.goLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			bomber.goRight();
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
			bomber.goUp();
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			bomber.goDown();
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bomber.putBomb();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			bomber.stopLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			bomber.stopRight();
		if (e.getKeyCode() == KeyEvent.VK_UP)
			bomber.stopUp();
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			bomber.stopDown();
		
	}
		@Override
	public void keyTyped(KeyEvent arg0) {}
}
