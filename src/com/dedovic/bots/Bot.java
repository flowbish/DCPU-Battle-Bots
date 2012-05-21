package com.dedovic.bots;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bot {
	private int health;
	private World world;
	private BodyDef botBodyDef;
	private PolygonShape botShape;
	private Body botBody;
	private FixtureDef botFixtureDef;
	private Rectangle rect;
	private static final float WIDTH = 1f;
	private static final float  HEIGHT = 1f;
	
	
	public Bot(float x, float y, World world){
		health = 100;
		rect = new Rectangle(x*10, y*10, WIDTH*100, HEIGHT*100);				
		
		this.world = world;
		botBodyDef = new BodyDef();
		botBodyDef.type = BodyType.DYNAMIC;
		botBodyDef.position.set(x, y);
		botBody = world.createBody(botBodyDef);
		botShape = new PolygonShape();
		botShape.setAsBox(WIDTH, HEIGHT);
		
		botFixtureDef = new FixtureDef();
		botFixtureDef.shape = botShape;
		botFixtureDef.density = 1f;
		botFixtureDef.friction = .3f;
		botFixtureDef.restitution = .5f;
		botBody.createFixture(botFixtureDef);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		float strength = 30f;
		
		if(input.isKeyPressed(Input.KEY_W))
			botBody.applyForce(botBody.getPosition(), new Vec2(0, strength));
		if(input.isKeyPressed(Input.KEY_S))
			botBody.applyForce(botBody.getPosition(), new Vec2(0, -strength));
		if(input.isKeyPressed(Input.KEY_D))
			botBody.applyForce(botBody.getPosition(), new Vec2(strength, 0));
		if(input.isKeyPressed(Input.KEY_A))
			botBody.applyForce(botBody.getPosition(), new Vec2(-strength, 0));
		
		rect.setLocation(botBodyDef.position.x*10, botBodyDef.position.y*10);
			
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(new Color(health, health, health));
		g.fill(rect);
	}
}
