package Entity;
import java.awt.Color;

import State.BlockState;


public class BombBlock extends BlockState{
	Color color;
	public BombBlock(){
	this.color=new Color(240,20,33);
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean solid() {
		return false;
	}

	@Override
	public boolean burnable() {
		return true;
	}	
}
