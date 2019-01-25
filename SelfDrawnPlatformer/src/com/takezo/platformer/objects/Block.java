package com.takezo.platformer.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.awt.Color;

import com.takezo.platformer.framework.GameObject;
import com.takezo.platformer.framework.ObjectId;

public class Block extends GameObject{

	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {

		
	}


	public void render(Graphics g) {

		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 32, 32);	//this just displays what a block looks like
		
	}


	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
