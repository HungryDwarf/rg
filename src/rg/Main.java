package rg;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;


public class Main {
	public final static int cellSize = 32;
	
	public static void main(String[] args) {

		GameMap map = new GameMap();
		Player player = new Player("Player.png");
		Enemy enemy = new Enemy("Player.png");

		VideoMode vm = new VideoMode(GameMap.mapWidth * cellSize, GameMap.mapHeight * cellSize);
		RenderWindow renderWindow = new RenderWindow(vm, "rg", WindowStyle.CLOSE);
		
		Clock clock = new Clock();
		float time;

		while (renderWindow.isOpen()) {
			time = clock.getElapsedTime().asSeconds();
			clock.restart();
			time = time * 100;

			for (Event myEvent : renderWindow.pollEvents()) {
				if (myEvent.type == Event.Type.CLOSED) {
					renderWindow.close();
				}
				if (myEvent.type == Event.Type.KEY_PRESSED) {
					switch (myEvent.asKeyEvent().key) {
					case A:
					case LEFT:
						player.move(-(cellSize), 0);
						break;
					case S:
					case DOWN:
						player.move(0, cellSize);
						break;
					case W:
					case UP:
						player.move(0, -(cellSize));
						break;
					case D:
					case RIGHT:
						player.move(cellSize, 0);
						break;
					default:
						player.move(0, 0);
						break;
					}
				}
			}

			if (Keyboard.isKeyPressed(Key.ESCAPE)) {
				renderWindow.close();
			}

			player.update();
			enemy.update();
			
			map.drawMap();
			for (int i = 0; i < GameMap.mapHeight; i++) {
				for (int j = 0; j < GameMap.mapWidth; j++) {
					renderWindow.draw(map.mapSprite[i][j]);
				}
			}
			renderWindow.draw(player.getSkin());
			renderWindow.draw(enemy.getSkin());
			
			renderWindow.draw(scoreText(player.getScore()));
			renderWindow.display();
		}
	}
	
	
	static Text scoreText(int score){
		Text txt = new Text();
		Font font = new Font();
		Path path = FileSystems.getDefault().getPath("FreeSans.ttf");
		try {
			font.loadFromFile(path);
		} catch (IOException e) {
			System.out.println("font alarm");
		}
		txt.setFont(font);
		txt.setPosition(0, 0);
		txt.setCharacterSize(24);
		txt.setColor(new Color(0, 0, 0));
		txt.setStyle(1);
		txt.setString("Coins: " + score);
		return txt;
	}
}