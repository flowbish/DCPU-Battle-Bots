package com.dedovic.bots;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Arena {

	private World world;

	private ArrayList<Bot> bots = new ArrayList<Bot>();
	
	public Arena(GameContainer container){
		Vec2 gravity = new Vec2(0, -10);
		boolean doSleep = true;
		world = new World(gravity, doSleep);

		bots.add(new Bot(5, 5, world));
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		world.step((delta/500f), 6, 2);
		for (Bot b : bots) {
			b.update(container, delta);
		}
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Bot b : bots) {
			b.render(container, g);
		}
	}	
}
