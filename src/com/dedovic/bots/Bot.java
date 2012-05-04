package com.dedovic.bots;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bot {
	protected float xPos, yPos;
	private int health;
	private Shape body;
	
	public Bot(float x, float y){
		xPos = x;
		yPos = y;
		health = 100;
		body = new Rectangle(x, y, 50, 50);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		body.setX(xPos);
		body.setY(yPos);
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(new Color(health, health, health));
		g.fill(body);
	}
	
	/**
	 * Check if this bot interests with the body of the provided bot.
	 * @param bot - The bot to check if it intersects with this one.
	 * @return True if the bots do intersect, false otherwise.
	 */
	public boolean intesects(Bot bot){
		return this.body.intersects(bot.body);
	}
	public void collide() {
		health--;		
	}	
}
