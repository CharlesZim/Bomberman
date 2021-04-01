package Entity;
import java.awt.Color;
import java.awt.Graphics;

import Main.Board;
import State.BlockState;


public class Fire extends MapObject {
	public static final int MAXTIME_FIRE=7;
	public int range;
	public Color color;
	public int counter;
	public boolean removed;
	public Board board;

	public Fire(int x, int y, int range,Board board){
		super(x,y,new Color(226,88,34),board,false);
		this.range=range;
		this.counter=0;
		this.removed=false;
		this.board=board;
		board.getBlockAt(x, y).spreadFireAt(x,y,range);
	}

	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return false;
	}

	public void update(){
		if(counter>=MAXTIME_FIRE){
			this.removed=true;
			board.getBlockAt(x,y).closeFireAt(x,y,range);
		}
		else{
			counter++;
		}
	}


	@Override
	public void changeState(BlockState state) {}

	@Override
	public void draw(Graphics g) {}
}
