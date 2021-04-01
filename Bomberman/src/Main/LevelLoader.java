package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Entity.Block;
import Entity.Enemy;


public class LevelLoader {
	Game game;
	
	private String levelInStr;
	public LevelLoader(Game game){
		this.game=game;
	}
	public void loadLevel(int x){
		readLevel(x);
		loadLevel();
		start();
	}

	public  void readLevel(int level)  {
		this.levelInStr="";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("level"+level+".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No level "+level+"existing");
		}
		while(scanner.hasNextLine()){
			levelInStr=levelInStr+scanner.nextLine()+"\n";	
		}
		scanner.close();
	}
	

	public void loadLevel() {
		game.board.reset();
		game.bomber.reset();
		String[] levelMap = levelInStr.split("\n");
		char currChar;
		for (int i = 0; i < Board.BLOCKNUMBER; i++) {
			String row=levelMap[i];
			for (int j = 0; j < Board.BLOCKNUMBER; j++) {
				Block block=new Block(j,i,game.board);
				currChar=row.charAt(j);
				 if(currChar=='e'){
					Enemy enemy=new Enemy(j,i, game.board);
					game.addEnemy(enemy);
				}
				 else if(currChar=='b'){
					 game.bomber.setX(j);
					 game.bomber.setY(i);
				 }
				 else {
					 block.changeStateTo(currChar);
				 }
				game.setBlockAt(i, j, block);
			}
		}
	}

	public void start(){
		game.setRunning(true);
		game.setCompleted(false);
		System.out.println("Start");
	}
}

