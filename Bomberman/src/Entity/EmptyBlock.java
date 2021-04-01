package Entity;
import java.awt.Color;

import State.BlockState;


public class EmptyBlock extends BlockState{
	public Color color;
	public EmptyBlock(){
		color=new Color(254,254,225);
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
		return false;
	}
}
