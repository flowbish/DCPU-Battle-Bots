package com.dedovic.bots;



import java.util.ArrayList;

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
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.ImageData;

import com.flowbish.dcpu16.DCPU;
import com.flowbish.dcpu16.Hardware;

public class Tank {
	Image tankImage;
	Image turretImage;
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private BodyDef tankBodyDef;
	private PolygonShape tankShape;
	private Body tankBody;
	private FixtureDef tankFixtureDef;

	private float turretAngle;
	private static final float WIDTH = 25;
	private static final float HEIGHT = 12;
	
	public Tank(float x, float y){
		
		turretAngle = 0;
		
		tankBodyDef = new BodyDef();
		tankBodyDef.type = BodyType.DYNAMIC;
		tankBodyDef.position.set(x, y);
		tankBody = Arena.world.createBody(tankBodyDef);
		tankShape = new PolygonShape();
		tankShape.setAsBox(WIDTH, HEIGHT);
		
		tankFixtureDef = new FixtureDef();
		tankFixtureDef.shape = tankShape;
		tankFixtureDef.density = .001f;
		tankFixtureDef.friction = .2f;
		tankFixtureDef.restitution = .5f;
		tankBody.createFixture(tankFixtureDef);
		
		try {
			tankImage = new Image("res/tank1.png");
			turretImage = new Image("res/turret1.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_W) && turretAngle > -50)
			turretAngle -= .2;
		if(input.isKeyDown(Input.KEY_S) && turretAngle < 10)
			turretAngle += .2;
		if(input.isKeyPressed(Input.KEY_SPACE))
			projectiles.add(new Projectile(tankBody.getPosition().x+30, tankBody.getPosition().y+2, turretAngle));
	
		
		for (Projectile p : projectiles) {
			p.update(container, delta);
		}
	}
	public void render(GameContainer container, Graphics g) throws SlickException {		
		turretImage.draw(tankBody.getPosition().x+30, tankBody.getPosition().y+2);
		turretImage.setRotation(turretAngle);
		tankImage.draw(tankBody.getPosition().x, tankBody.getPosition().y);
		for (Projectile p : projectiles) {
			p.render(container, g);
		}
	}
	
	public String getData() {
		return null;
	}
}
