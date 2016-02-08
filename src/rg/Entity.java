package rg;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Entity {
	
	float xPos = 0, yPos = 0;
	float xSpeed = 0, ySpeed = 0;
	Sprite skin;
	IntRect intRect = new IntRect(0, 0, 32, 32);
	
	Entity(String pathToTexture, int mapHeight, int mapWidth) {
		Texture playerTexture = new Texture();
		
		try {
			playerTexture.loadFromFile(Paths.get(pathToTexture));
		} catch(IOException ex) {
		    ex.printStackTrace();
		}
		
		skin = new Sprite(playerTexture);
		skin.setTextureRect(intRect);
	}
	
	abstract void update(float time);

}
