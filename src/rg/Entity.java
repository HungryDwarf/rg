package rg;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Entity {
	
	protected int xPos = 0;
	protected int yPos = 0;
	private Sprite skin;
	private int playerSkinHeight = 32;
	private int playerSkinWidth = 32;
	private IntRect intRect = new IntRect(0, 0, playerSkinWidth, playerSkinHeight);
	
	protected int level;
	protected HashMap<String, Integer> stats = new HashMap<String, Integer>();
	
	Entity(String pathToTexture) {
		Texture playerTexture = new Texture();
		
		try {
			playerTexture.loadFromFile(Paths.get(pathToTexture));
		} catch(IOException ex) {
		    ex.printStackTrace();
		}
		
		skin = new Sprite(playerTexture);
		skin.setTextureRect(intRect);
		
		stats.put("attack", 1);
		stats.put("defense", 1);
		System.out.println(stats);
	}
	
	abstract void move(int dx, int dy);
	
	public int[] getPos(){
		int[] res = new int[2];
		res[0] = xPos;
		res[1] = yPos;
		return res;
	}
	
	void update() {
		skin.setPosition(xPos, yPos);
	}
	
	Sprite getSkin(){
		return skin;
	}

}
