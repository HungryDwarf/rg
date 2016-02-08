package rg;

public class Player extends Entity {

	Player(String pathToTexture, int mapHeight, int mapWidth) {
		super(pathToTexture, mapHeight, mapWidth);
		xPos = (mapHeight / 2) - 16;
		yPos = (mapWidth / 2) - 16;
	}

	void update(float time) {
		xPos = xPos + (xSpeed * time);
		// ќбработка столконвений по оси х
		collision(1);
		yPos = yPos + (ySpeed * time);
		// ќбработка столкновений по оси у
		collision(0);
		skin.setPosition(xPos, yPos);
		xSpeed = ySpeed = 0;

	}

	
	// мен€ть кху€м, не понимаю, что здесь происходит
	// но оно работает
	// но кху€м
	void collision(int collisionType) {
		for (int j = (int) xPos / 64; j < (((int) xPos + 32) / 64) + 1; j++) {
			for (int i = (int) yPos / 64; i < (((int) yPos + 32) / 64) + 1; i++) {
				if (Map.map[i][j] == " ")
					;
				else {
					if ((ySpeed < 0) & (collisionType == 0))
						yPos = i * 64 + 65;
					if ((ySpeed > 0) & (collisionType == 0))
						yPos = i * 64 - 33;// 31 это ширина персонажа!!!
					if ((xSpeed < 0) & (collisionType == 1))
						xPos = j * 64 + 65;
					if ((xSpeed > 0) & (collisionType == 1))
						xPos = j * 64 - 33;// 31 это ширина персонажа!!!
				}
			}
		}
	}

}
