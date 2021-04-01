package State;
import java.awt.Color;


public class FireState extends BlockState{
	Color color;
	public FireState(){
		this.color=new Color(240,240,0);
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
	public String toString(){
		return "FireState";
	}
}
