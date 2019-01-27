package com.takezo.platformer.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.takezo.platformer.objects.Bullet;
import com.takezo.platformer.window.Handler;

public class KeyInput extends KeyAdapter{
	
	Handler handler;
	int direction = 1;
	//1 = right
	//-1 = left
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player) {
				if(key == KeyEvent.VK_A)
					tempObject.setVelX(-5);
				if(key == KeyEvent.VK_D)
					tempObject.setVelX(5);
				if(key == KeyEvent.VK_W && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-9);
				}
				if(key == KeyEvent.VK_SPACE)
					handler.addObject(new Bullet(tempObject.getX(), tempObject.getY()+10, ObjectId.Bullet, (tempObject.getDirection()*10)));
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
				
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player) {
				if(key == KeyEvent.VK_A)
					tempObject.setVelX(0);
				if(key == KeyEvent.VK_D)
					tempObject.setVelX(0);		
			}
		}
	}

}
