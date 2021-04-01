package State;
import java.awt.Color;


public abstract  class BlockState {
	public abstract Color getColor();
	public abstract boolean burnable();
	public abstract boolean solid();
	
	public String toString(){
		return"";
	}
}

