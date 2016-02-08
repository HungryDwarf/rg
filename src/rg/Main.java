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
		Map m = new Map();
		
		VideoMode vm = new VideoMode(m.mapWidth*64, m.mapHeight*64);
		RenderWindow renderWindow = new RenderWindow(vm, "rg", WindowStyle.CLOSE);
		
		Clock clock = new Clock();
		float time;

		while(renderWindow.isOpen()){
			time = clock.getElapsedTime().asSeconds();
			clock.restart();
			time = time*500;
			//player.update(time);
			
			for (Event myEvent : renderWindow.pollEvents()) {
				if (myEvent.type == Event.Type.CLOSED) {
					renderWindow.close();
				}
			}

			if (Keyboard.isKeyPressed(Key.ESCAPE)) {
				renderWindow.close();
			}
			
			for (int i = 0; i < m.mapHeight; i++) {
				for (int j = 0; j < m.mapWidth; j++) {
					renderWindow.draw(m.mapSprite[i][j]);
				}
			}
			renderWindow.display();
		}
	}
}