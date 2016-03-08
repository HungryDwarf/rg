package rg;

public class Player extends Entity {

	int cellSize = Main.cellSize;
	private int score = 0;
	Player(String pathToTexture) {
		super(pathToTexture);
		xPos = 1 * cellSize;//(mapHeight / 2);
		yPos = 1 * cellSize;//(mapWidth / 2);
		while(GameMap.getMap()[xPos/cellSize][yPos/cellSize].equals("w")){
			xPos += cellSize;
		}
		stats.put("attack", 2);
		stats.put("defense", 2);
	}
	
	void move(int dx, int dy) {
		if(collision(dx, dy) == 1) { //collision, do nothing
			return;
		}
		xPos += dx;
		yPos += dy;
		take_coin();
	}
	
	int collision(int dx, int dy) {
		try{
			if(GameMap.getMap()[((yPos + dy)/cellSize)][((xPos + dx)/cellSize)].equals("w")) {
				return 1;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
		}
		return 0;
	}
	
	void take_coin(){
		if(GameMap.getMap()[(int) yPos/cellSize][(int) xPos/cellSize].equals("c")){
			score++;
			GameMap.setMap((int) yPos/cellSize, (int) xPos/cellSize, "a");
		}
	}
	
	int getScore(){
		return score;
	}

}
