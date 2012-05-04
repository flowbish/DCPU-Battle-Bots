package com.dedovic.bots;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Runner extends BasicGame{
	private static int width = 1000;
	private static int height = 1000;
	private GameState state;
	private World world;

	@Override
	public void init(GameContainer container) throws SlickException {
		state = GameState.RUNNING;
		world = new World(container);
		world.add(new Bot(50, 50));
		world.add(new Bot(250, 250));
		world.add(new BotPlayer(350, 350));
	}
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
			world.update(container, delta);
	}
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		world.render(container, g);
	}

	
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Runner("Test"));
			container.setDisplayMode(width, height, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	public Runner(String title) {
		super(title);
	}
}
