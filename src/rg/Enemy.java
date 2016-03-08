package rg;

public class Enemy extends Entity {

	public Enemy(String pathToTexture) {
		super(pathToTexture);
		xPos = GameMap.mapHeight*Main.cellSize - 2*Main.cellSize;
		yPos = GameMap.mapWidth*Main.cellSize - 2*Main.cellSize;
	}

	void move(int dx, int dy) {

	}

}
