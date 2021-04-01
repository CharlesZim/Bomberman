package Main;
import java.awt.Graphics;
import java.util.ArrayList;

import Entity.Block;
import Entity.Bomb;
import Entity.Enemy;
import Entity.Fire;
import Entity.MapObject;


public class Board {
	public static final int BLOCKNUMBER=Game.HEIGHT/MapObject.SIZE;
	public MapObject[][] board;
	public ArrayList<Bomb> bombs;
	public ArrayList<Enemy> enemies;
	public ArrayList<Fire> fires;
	public boolean allEnemiesRemoved;

	public Board(){
		board=	new MapObject[BLOCKNUMBER][BLOCKNUMBER];
		for (int i = 0; i < BLOCKNUMBER; i++) {
			for (int j = 0; j < BLOCKNUMBER; j++) {
				board[i][j]=new Block(i,j,this);
			}
		}
		enemies=new ArrayList<Enemy>();
		bombs=new ArrayList<Bomb>();
		fires=new ArrayList<Fire>();
		allEnemiesRemoved=false;
	}

	public void update() {
		removeDiedEnemies();	
		updateFires();
		updateBombs();
		updateEnemies();
		removedDiedBombsAndFires();
		
	}

	private void updateEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
		}
	}

	private void updateBombs() {
		for (int i = 0; i < bombs.size(); i++) {
			bombs.get(i).update();
		}
	}

	private void updateFires() {
		for (int i = 0; i < fires.size(); i++) {
			fires.get(i).update();
		}
	}
	private void removeDiedEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			if(!(enemies.get(i).isAlive)){
				enemies.remove(i);
			}
		}
		if(enemies.size()==0){
			allEnemiesRemoved=true;
		}
	}
	public void draw(Graphics g) {
		for (int i = 0; i < BLOCKNUMBER; i++) {
			for (int j = 0; j < BLOCKNUMBER; j++) {
				board[i][j].draw(g);
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
	}

	public void readLevel(){}
	
	public void addEnemy(Enemy gameObj) {
		enemies.add(gameObj);
	}
	
	public void reset() {
		board=new MapObject[BLOCKNUMBER][BLOCKNUMBER];
		enemies=new ArrayList<Enemy>();
		bombs=new ArrayList<Bomb>();
		fires=new ArrayList<Fire>();
		allEnemiesRemoved=false;
	}
	
	public void setBlockBlockAt(int x, int y, Block block) {
		board[y][x]=block;
	}

	public Block getBlockAt(int x, int y) {
		return (Block)board[x][y];
		
	}
	private void removedDiedBombsAndFires() {
		for (int i = 0; i <bombs.size(); i++) {
			if(bombs.get(i).removed){
				bombs.remove(i);
			}
		}
		for (int i = 0; i < fires.size(); i++) {
			if(fires.get(i).removed){
				fires.remove(i);
			}
		}
	}
}
