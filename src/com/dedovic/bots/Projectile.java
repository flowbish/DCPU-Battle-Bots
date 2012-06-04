package com.dedovic.bots;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Projectile {

	Image projectileImage;
	private BodyDef projectileBodyDef;
	private PolygonShape projectileShape;
	private Body projectileBody;
	private FixtureDef projectileFixtureDef;

	private static final float force = 1500;
	private static final float damage = 25;
	
	public Projectile(float x, float y, float angle){
		
		projectileBodyDef = new BodyDef();
		projectileBodyDef.type = BodyType.DYNAMIC;
		projectileBodyDef.position.set(x, y);
		projectileBody = Arena.world.createBody(projectileBodyDef);
		projectileShape = new PolygonShape();
		projectileShape.setAsBox(1,1);
		
		projectileFixtureDef = new FixtureDef();
		projectileFixtureDef.shape = projectileShape;
		projectileFixtureDef.density = .001f;
		projectileFixtureDef.friction = .2f;
		projectileFixtureDef.restitution = .5f;
		projectileBody.createFixture(projectileFixtureDef);
		
		try {
			projectileImage = new Image("res/projectile1.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		projectileBody.applyForce(new Vec2(force * (float) Math.sin(Math.toRadians(angle+90)), force * (float) Math.cos(Math.toRadians(90-angle))) , projectileBody.getPosition()); 
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		
	}
	public void render(GameContainer container, Graphics g) throws SlickException {		
		projectileImage.draw(projectileBody.getPosition().x, projectileBody.getPosition().y);
	}
	
	public String getData() {
		return null;
	}
}
