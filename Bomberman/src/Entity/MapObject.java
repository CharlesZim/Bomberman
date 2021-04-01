package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Main.Board;
import State.BlockState;


public abstract  class MapObject{
	public static final int SIZE = 30;
	int x;
	int y;
	Color color;
	BlockState state;
	Board board;
	public boolean isAlive;
	public boolean removed;
	
	public MapObject(int x,int y, Color color,Board board,boolean isAlive){
		this.x=x;
		this.y=y;
		this.color=color;
		this.board=board;
		this.isAlive=isAlive;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getX(){
		return this.x;
	}
	public void setColor(Color color){
		this.color=color;
	}
	public int getY(){
		return this.y;
	}
	public BlockState getState(){
		return state;
	}
	
	public abstract boolean burnable();
	public abstract boolean solid();
	public abstract void draw(Graphics g);
	
	public void changeState(BlockState state){}
	public void update() {		
	}	
}
