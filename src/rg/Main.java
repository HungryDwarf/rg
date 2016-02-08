package rg;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;

public class Main {

	public static void main(String[] args) {
		
		final int cellSize = 64;
		
		Map map = new Map();
		Player player = new Player("Player.png", map.mapWidth*cellSize, map.mapHeight*cellSize);
		
		VideoMode vm = new VideoMode(map.mapWidth*cellSize, map.mapHeight*cellSize);
		RenderWindow renderWindow = new RenderWindow(vm, "rg", WindowStyle.CLOSE);
		
		Clock clock = new Clock();
		float time;

		while(renderWindow.isOpen()){
			time = clock.getElapsedTime().asSeconds();
			clock.restart();
			time = time*250;
			player.update(time);
			
			for (Event myEvent : renderWindow.pollEvents()) {
				if (myEvent.type == Event.Type.CLOSED) {
					renderWindow.close();
				}
			}

			if (Keyboard.isKeyPressed(Key.ESCAPE)) {
				renderWindow.close();
			}
			if (Keyboard.isKeyPressed(Key.LEFT)) {
				player.xSpeed = (float) -1;
			}
			if (Keyboard.isKeyPressed(Key.RIGHT)) {
				player.xSpeed = (float) 1;
			}
			if (Keyboard.isKeyPressed(Key.UP)) {
				player.ySpeed = (float) -1;
			}
			if (Keyboard.isKeyPressed(Key.DOWN)) {
				player.ySpeed = (float) 1;
			}
			
			for (int i = 0; i < map.mapHeight; i++) {
				for (int j = 0; j < map.mapWidth; j++) {
					renderWindow.draw(map.mapSprite[i][j]);
				}
			}
			renderWindow.draw(player.skin);
			renderWindow.display();
		}
	}
}