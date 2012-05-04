package com.dedovic.bots;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BotPlayer extends Bot {

	public BotPlayer(float x, float y) {
		super(x, y);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_W))
			yPos--;
		if(input.isKeyDown(Input.KEY_S))
			yPos++;
		if(input.isKeyDown(Input.KEY_D))
			xPos++;
		if(input.isKeyDown(Input.KEY_A))
			xPos--;
		super.update(container, delta);
	}

}
