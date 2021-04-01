package Entity;
import java.awt.Color;
import java.awt.Graphics;


import Main.Board;
import State.BlockState;
import State.FireState;

public class Block extends MapObject{
	
	public Block(int x,int y,Board board){
		super(x,y,Color.GRAY,board,false);
		this.state=new EmptyBlock();
	}

	public void changeState(BlockState state) {
		this.state=state;
	}

	@Override
	public boolean burnable() {
		return this.state.burnable();
	}
	@Override
	public boolean solid() {
		return state.solid();
	}

	@Override
	public void draw(Graphics g){
		g.setColor(state.getColor());
		g.fillRect(x*SIZE, y*SIZE, SIZE, SIZE);
	}

	public void changeStateTo(char ch){
		if(ch=='s'){
			this.changeState(new SoftWall());
		}
		else if(ch=='h'){
			this.changeState(new HardWall());
		}
		else{
			this.changeState(new EmptyBlock());
		}
	}

	public void spreadFireAt(int x, int y, int range) {
		this.changeState(new FireState());
		board.getBlockAt(x,y+1).sendFireDown(range);
		board.getBlockAt(x+1, y).sendFireRight(range);
		board.getBlockAt(x-1, y).sendFireLeft(range);
		board.getBlockAt(x, y-1).sendFireUp(range);
	}
	
	public void closeFireAt(int x, int y, int range) {
		changeState(new EmptyBlock());
		board.getBlockAt(x,y+1).sendCloseFireDown(range);
		board.getBlockAt(x+1, y).sendCloseFireRight(range);
		board.getBlockAt(x-1, y).sendCloseFireLeft(range);
		board.getBlockAt(x, y-1).sendCloseFireUp(range);
	}

	private void sendFireUp(int range) {
		if(state.solid()){
			burnSolid();
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x, y-1).sendFireUp(range-1);
			}
		}
	}

	private void burnSolid() {
		if(state.burnable()){
			changeState(new FireState());
		}
	}

	private void sendFireLeft(int range) {
		if(state.solid()){
			burnSolid();
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x-1, y).sendFireLeft(range-1);
			}
		}
	}

	private void sendFireRight(int range) {
		if(state.solid()){
			burnSolid();
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x+1, y).sendFireRight(range-1);
			}
		}
	}

	private void sendFireDown(int range) {
		if(state.solid()){
			burnSolid();
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x, y+1).sendFireDown(range-1);
			}
		}
	}



	private void sendCloseFireDown(int range) {
		if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(y+1<Board.BLOCKNUMBER)
				board.getBlockAt(x,y+1).sendCloseFireDown(range-1);	
			}
		}
	}

	private void sendCloseFireLeft(int range) {
		if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(x-1>0)
					board.getBlockAt(x-1, y).sendCloseFireLeft(range-1);
			}
		}
	}

	private void sendCloseFireRight(int range) {
		if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(x+1<Board.BLOCKNUMBER)
					board.getBlockAt(x+1, y).sendCloseFireRight(range-1);
			}
		}
	}

	private void sendCloseFireUp(int range) {
		if(!state.solid()){
		
			changeState(new EmptyBlock());
			if(range>1){
				if(y-1>0)
					board.getBlockAt(x, y-1).sendCloseFireUp(range-1);
			}
		}
	}
}
