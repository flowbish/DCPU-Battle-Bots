package com.dedovic.bots;

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
	private BodyDef groundDef;
	private BodyDef boxDef;
	private PolygonShape groundShape;
	private PolygonShape boxShape;
	private Body groundBody;
	private Body boxBody;
	private FixtureDef boxFixture;
	
	Rectangle ground;
	Rectangle box;
	
	public Arena(GameContainer container){
		Vec2 gravity = new Vec2(0, -10F);
		boolean doSleep = true;
		
		world = new World(gravity, doSleep);
		
		groundDef = new BodyDef();
		groundDef.position.set(0, -10f);
		groundBody = world.createBody(groundDef);
		groundShape= new PolygonShape();
		groundShape.setAsBox(50f, 10f);
		groundBody.createFixture(groundShape, 0);
		
		boxDef = new BodyDef();
		boxDef.type = BodyType.DYNAMIC;
		boxDef.position.set(0, 4f);
		boxBody = world.createBody(boxDef);
		boxShape = new PolygonShape();
		boxShape.setAsBox(1f, 1f);
		
		boxFixture = new FixtureDef();
		boxFixture.shape = boxShape;
		boxFixture.density = 1f;
		boxFixture.friction = .3f;
		boxFixture.restitution = .5f;
		boxBody.createFixture(boxFixture);
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		world.step((delta/1000f), 6, 2);

	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.fill(new Rectangle(boxBody.getPosition().x*10, boxBody.getPosition().y*100, 50, 50));
	}	
}
