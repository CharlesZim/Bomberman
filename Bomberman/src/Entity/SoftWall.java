package Entity;
import java.awt.Color;

import State.BlockState;


public class SoftWall extends BlockState{
	Color color;
	public SoftWall(){
		this.color= new Color(203,176,137);
	}
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return true;
	}
}
