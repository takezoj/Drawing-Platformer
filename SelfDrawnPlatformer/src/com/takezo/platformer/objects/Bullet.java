package com.takezo.platformer.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.takezo.platformer.framework.GameObject;
import com.takezo.platformer.framework.ObjectId;

public class Bullet extends GameObject{

	public Bullet(float x, float y, ObjectId id, int velX) {
		super(x, y, id);
		this.velX = velX;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		
	}

	public void render(Graphics g) {
		//draw color and size of bullet
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 8, 8);
		
	}

	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 8, 8);
	}

}
