package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Main.Board;


public class MovingObject extends MapObject{
	static final int LEFT=1;
	static final int RIGHT=2;
	static final int UP=3;
	static final int DOWN=4;
	static final int SPEED=1;
	public int dir;
	public int speed;
	public boolean isAlive;
	public Board board;
	public int xd,yd;
	
public MovingObject(int x, int y,Color color,Board board){
	super(x,y,color,board,true);
	this.isAlive=true;
	this.speed=1;
	this.xd=0;
	this.yd=0;
	this.removed=false;
}
	
	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(x*MapObject.SIZE, y*MapObject.SIZE, SIZE, SIZE);
	}
	
public boolean colisionWithFire() {
	if(board.getBlockAt(x,y).state.toString().equals("FireState")){
		return true;
	}
	return false;

	}

protected boolean canWalk() {

	if(dir==RIGHT){
		return !board.board[x+1][y].solid();
	}
	else if(dir==DOWN){
		return !board.board[x][y+1].solid();
	}
	else if(dir==UP){
		return !board.board[x][y-1].solid();
	}
	else if(dir==LEFT){
		if(x-1>0)
			return !board.board[x-1][y].solid();
	}
	return false;
}

public void goRight() {
	yd=0;
	xd = speed;
}

public void goLeft() {
	yd=0;
	xd = -speed;
}

public void goUp() {
	xd=0;
	yd = -speed;
}

public void goDown() {
	xd=0;
	yd = speed;
}
public void stopRight() {
	if (xd > 0) {
		xd = 0;
	}
}

public void stopLeft() {
	if (xd < 0) {
		xd = 0;
	}
}
public void stopUp() {
	if (yd < 0) {
		yd = 0;
	}
}

public void stopDown() {
	if (yd > 0) {
		yd = 0;
	}
}

public void move(int xd, int yd) {
	if(xd != 0 && yd != 0) {
		move(xd, 0);
		move(0, yd);
		return;
	}

	if(xd > 0) dir = RIGHT;
	if(xd < 0) dir = LEFT;
	if(yd > 0) dir = DOWN;
	if(yd < 0) dir = UP;

	if(canWalk()){
		this.setX(this.getX()+xd);
		this.setY(this.getY()+yd);	
	}
	else{
		moveOtherwise();
	}
}

public  void moveOtherwise(){}
}
