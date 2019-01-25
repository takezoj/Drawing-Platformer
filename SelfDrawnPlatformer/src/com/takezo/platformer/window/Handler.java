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
	
	public void createLevel() {	//makes the actual block objects
		for(int xx = 0; xx < Game.WIDTH + 32; xx += 32)
			//addObject(new Block(x coord, y coord, ObjectId.Block))
			addObject(new Block(xx, Game.HEIGHT - 32, ObjectId.Block));
		
		for(int xx = 200; xx < 500; xx += 32)
			addObject(new Block(xx, 450, ObjectId.Block));
		
		for(int xx = Game.WIDTH - 64; xx < Game.WIDTH - 32; xx += 32)
			addObject(new Block(xx, 500, ObjectId.Block));
		
		for(int xx = 0; xx < 80; xx += 32)
			addObject(new Block(xx, 350, ObjectId.Block));
		
		for(int yy = 400; yy < Game.HEIGHT - 80; yy += 32)
			addObject(new Block(Game.WIDTH - 200, yy, ObjectId.Block));
	}
	
}
