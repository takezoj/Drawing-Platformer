package com.takezo.platformer.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.takezo.platformer.framework.GameObject;
import com.takezo.platformer.framework.ObjectId;
import com.takezo.platformer.objects.Block;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);	//sets temp object to whatever is current in list
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);	//sets temp object to whatever is current in list
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createLevel() {
		for(int xx = 0; xx < Game.WIDTH + 32; xx += 32)
			addObject(new Block(xx, Game.HEIGHT - 32, ObjectId.Block));
	}
	
}
