package com.dedovic.bots;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class World {
	private int height;
	private int width;
	private ArrayList<Bot> bots = new ArrayList<Bot>();
	
	public World(GameContainer container){
		height = container.getHeight();
		width = container.getWidth();
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		checkCollisions();
		checkDead();
		
		for (Bot b : bots) {
			b.update(container, delta);
		}
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Bot b : bots) {
			b.render(container, g);
		}
	}
	
	/**
	 * Add new bot to this world
	 * @param b - The new bot
	 */
	public void add(Bot b){
		bots.add(b);
	}
	/**
	 * Check collisions of all bots in this world. Calls collide() if two bots collide.
	 */
	private void checkCollisions(){
		for (int i = 0; i < bots.size(); i++) {
			for (int j = 0; j < bots.size(); j++) {
				if(i != j && bots.get(i).intesects(bots.get(j)))
					bots.get(i).collide();
			}
			
		}
	}
	/**
	 * Check health of all bots in this world. Removes any that are dead.
	 */
	private void checkDead(){
		for (Bot b : bots) {
			if(b.isDead())
				bots.remove(b);
		}
	}

	
	
}
