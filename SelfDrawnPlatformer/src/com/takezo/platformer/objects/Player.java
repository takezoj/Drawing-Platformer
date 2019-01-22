package com.takezo.platformer.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.takezo.platformer.framework.GameObject;
import com.takezo.platformer.framework.ObjectId;

public class Player extends GameObject{
	
	private int width = 32, height = 64;
	private float gravity = 0.3f;
	private final float MAXSPEED = 10;

	public Player(float x, float y, ObjectId id) {
		super(x, y, id);

	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		//y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAXSPEED)
				velY = 10;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		return new Rectangle((int)(x+(width/2)-(width/2/2)), ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int)(x+(width/2)-(width/2/2)), (int)y, (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x+width-5, (int)y+5, (int)5, (int)height-10);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}

}
