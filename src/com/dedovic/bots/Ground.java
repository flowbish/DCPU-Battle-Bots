package com.dedovic.bots;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Ground {
	private BodyDef groundBodyDef;
	private PolygonShape groundShape;
	private Body groundBody;
	private Shape ground;
	
	public Ground(World world) {
		groundBodyDef = new BodyDef();
		groundBodyDef.position.set(0, 750f);
		groundBody = world.createBody(groundBodyDef);
		groundShape= new PolygonShape();
		groundShape.setAsBox(750f, 50f);
		groundBody.createFixture(groundShape, 0);
		
		ground = new Rectangle(0, 715, 750, 35);
	}
	public void update(GameContainer container, int delta) throws SlickException {
		
	}
	public void render(GameContainer container, Graphics g) throws SlickException {		
		g.fill(ground);
	}
}
