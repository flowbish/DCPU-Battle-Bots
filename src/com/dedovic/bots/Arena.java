package com.dedovic.bots;

import java.util.ArrayList;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Arena {

	public static World world;
	private Ground ground;
	private ContactListener cl;
	
	private ArrayList<Tank> bots = new ArrayList<Tank>();
	
	
	public Arena(GameContainer container){
		Vec2 gravity = new Vec2(0, 10);
		boolean doSleep = true;
		world = new World(gravity, doSleep);
		ground = new Ground(world);	
		cl = new ContactListener() {
			
			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub
				
			}
		};
		
		bots.add(new Tank(5, 650));

	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		world.step((delta/500f), 6, 2);
		
		for (Tank b : bots) {
			b.update(container, delta);		
		}
	}
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Tank b : bots) {
			b.render(container, g);
		}
		ground.render(container, g);
	}	
}
