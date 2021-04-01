package Entity;
import java.awt.Color;

import State.BlockState;


public class HardWall extends BlockState{
	Color color;
	public HardWall(){
		this.color= new Color(144,109,67);
	}

	@Override
	public Color getColor() {

		return color;
	}

	@Override
	public boolean solid() {

		return true;
	}
	@Override
	public boolean burnable() {
		return false;
	}
}
