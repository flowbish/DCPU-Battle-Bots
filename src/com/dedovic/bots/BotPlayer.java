package com.dedovic.bots;

import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BotPlayer extends Bot {

	public BotPlayer(float x, float y, World world) {
		super(x, y, world);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		super.update(container, delta);
	}

}
