package com.dedovic.bots;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bot {
	private int health, rotation;
	private Shape body;
	private World world;
	private BodyDef botBodyDef;
	private PolygonShape botShape;
	private Body botBody;
	private FixtureDef botFixtureDef;
	protected float xPos, yPos;
	
	public Bot(float x, float y, World world){
		xPos = x;
		yPos = y;
		health = 100;
		
		this.world = world;
		botBodyDef = new BodyDef();
		botBodyDef.type = BodyType.DYNAMIC;
		botBodyDef.position.set(x, y);
		botBody = world.createBody(botBodyDef);
		botShape = new PolygonShape();
		botShape.setAsBox(1f, 1f);
		
		botFixtureDef = new FixtureDef();
		botFixtureDef.shape = botShape;
		botFixtureDef.density = 1f;
		botFixtureDef.friction = .3f;
		botFixtureDef.restitution = .5f;
		botBody.createFixture(botFixtureDef);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		//TODO: Death handling
		//TODO: Collision handling
		//TODO: Act
			
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(new Color(health, health, health));
		g.fill(body);
	}
}
