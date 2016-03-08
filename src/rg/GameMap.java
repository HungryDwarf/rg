package rg;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class GameMap {
	static int mapHeight = 10;
	static int mapWidth = 10;
	static String[][] map = generateMap(mapHeight, mapWidth);

	Sprite[][] mapSprite = new Sprite[mapHeight][mapWidth];

	GameMap() {

		Texture mapTexture = new Texture();

		try {
			mapTexture.loadFromFile(Paths.get("Map.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				mapSprite[i][j] = new Sprite(mapTexture);
			}
		}

		drawMap();
	}

	void drawMap() {
		for (int h = 0; h < mapHeight; h++) {
			for (int w = 0; w < mapWidth; w++) {
				if (map[h][w].equals("a"))
					mapSprite[h][w].setTextureRect(new IntRect(128, 0, 32, 32)); // empty
				if (map[h][w].equals("w"))
					mapSprite[h][w].setTextureRect(new IntRect(64, 128, 32, 32)); // wall
				if (map[h][w].equals("c"))
					mapSprite[h][w].setTextureRect(new IntRect(160, 0, 32, 32)); // coin

				mapSprite[h][w].setPosition(Main.cellSize * w, Main.cellSize * h);
			}
		}
	}

	static String[][] getMap() {
		return map;
	}

	static void setMap(int x, int y, String s) {
		map[x][y] = s;
	}

	private static String[][] generateMap(int h, int w) {
		String[][] map = new String[h][w];

		Arrays.fill(map[0], "w");

		for (int i = 1; i < h; i++) {

			for (int j = 0; j < w; j++) {
				double d = Math.random();

				if(j == 0 || j == w-1){
					map[i][j] = "w";
					continue;
				}
				
				if (d < 0.1) {
					map[i][j] = "w";
				} else if (d < 0.7) {
					map[i][j] = "a";
				} else {
					map[i][j] = "c";
				}
			}
		}
		Arrays.fill(map[h - 1], "w");

		return map;
	}
}
