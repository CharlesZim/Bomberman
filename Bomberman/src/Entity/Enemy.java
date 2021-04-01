package Entity;
import java.awt.Color;
import java.util.Random;

import Main.Board;


public class Enemy extends MovingObject{
	static final int MAXSPEED=5;
	int freq=10;
	int frequency=5;
	Random random;
	int count;
	public Enemy(int x ,int y,Board board){
		super(x,y,Color.red,board);
		this.board=board;
		count=0;
		random=new Random();
		this.dir=LEFT;
		this.count=0;
		this.speed=1;
		this.frequency=random.nextInt(MAXSPEED)+1;
	}

	public void moveOtherwise(){
		changeDirection();
		moveForward();
	}

	private void changeDirection() {
		int nextDir=random.nextInt(4);
		if(nextDir+1==dir){
			changeDirection();
		}
		else{
			dir=nextDir+1;
		}	
	}

	private void moveForward() {
		if(dir==RIGHT){
			goRight();
		}
		else if(dir==LEFT){
			goLeft();
		}
		else if(dir==UP){
			goUp();
		}
		else if(dir==DOWN){
			goDown();
		}
		
		move(xd, yd);

	}

	public void update(){
		if(isAlive){
			if(colisionWithFire()){
				isAlive=false;
			}
			else{	
				if(count>frequency){
					moveForward();	
					count=0;
				}		
				else{
					count++;
				}
			}
		}
	}
}
