package rg;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Map {
	static String[][] map = new String[][] { 
		{ "w", "w", "w", "w", "w" }, 
		{ "w", " ", " ", " ", "w" },
		{ "w", " ", " ", " ", "w" }, 
		{ "w", " ", " ", " ", "w" }, 
		{ "w", " ", " ", " ", "w" },
		{ "w", "w", "w", "w", "w" } };
	int mapHeight = map.length;
	int mapWidth = map[0].length;
	Sprite[][] mapSprite = new Sprite[mapHeight][mapWidth];

	Map() {

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

		for (int h = 0; h < mapHeight; h++) {
			for (int w = 0; w < mapWidth; w++) {
				if (map[h][w] == " ")
					mapSprite[h][w].setTextureRect(new IntRect(128, 0, 64, 64));
				if (map[h][w] == "w")
					mapSprite[h][w].setTextureRect(new IntRect(64, 128, 64, 64));

				mapSprite[h][w].setPosition(64 * w, 64 * h);
			}
		}
	}
}
