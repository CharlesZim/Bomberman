package Entity;

import java.awt.Color;

import Main.Board;
import Main.KeyboardHandler;


public class Player extends MovingObject{
	KeyboardHandler keyboardHandler;

	public Player(int x,int y, KeyboardHandler keyboardHandler, Board board){
		super(x,y,new Color(0,0,210),board);
		this.keyboardHandler=keyboardHandler;	
		this.speed=SPEED;
		this.board=board;
	}
	public void update() {
		if(xd!=0||yd!=0){
			move(xd,yd);
		}
		
		if(colisionWithEnemy()){
			isAlive=false;
		}
		
		if(colisionWithFire()){
			isAlive=false;
			System.out.println("Game Over");
		}
	}

	private boolean BlockAvailable() {
		for(int i = 0; i < board.bombs.size(); i++) {
			if((x) == board.bombs.get(i).x &&(y) == board.bombs.get(i).y) return false;
		}
		return true;
	}

	public void putBomb() {
		if(BlockAvailable()){
			Bomb bomb = new Bomb(x, y, board, 2);
			board.bombs.add(bomb);
			board.board[x][y].changeState(new BombBlock());}
	}

	private boolean colisionWithEnemy() {		
		for(int i = 0; i < board.enemies.size(); i++) {
			if(x == board.enemies.get(i).x && y == board.enemies.get(i).y) return true;
		}
		return false;
	}

	public void reset() {
		this.setX(1);
		this.setY(1);
	}
}


