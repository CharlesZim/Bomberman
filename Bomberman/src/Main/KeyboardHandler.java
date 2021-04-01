package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entity.Player;

public class KeyboardHandler implements KeyListener {
	Player player;
	public KeyboardHandler(Player player){
		this.player=player;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.goLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.goRight();
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
			player.goUp();
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			player.goDown();
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			player.putBomb();
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(1);

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.stopLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.stopRight();
		if (e.getKeyCode() == KeyEvent.VK_UP)
			player.stopUp();
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			player.stopDown();
		
	}
		@Override
	public void keyTyped(KeyEvent arg0) {}
}
