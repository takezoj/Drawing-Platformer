package com.takezo.platformer.window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.takezo.platformer.framework.ObjectId;
import com.takezo.platformer.objects.Block;

import java.awt.Color;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -6735838867349853418L;

	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT; 
	
	//Object
	Handler handler;
	
	public void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		
		handler.createLevel();
	}
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				//run amount of ticks (fps) at 60
				tick();
				updates++;
				delta--;
			}	
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3); //sets number of preloaded images to 3
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		////////////////////////////////////
		//Draw graphics here
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);
		
		////////////////////////////////////
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		new Window(800, 600, "Dis a Gayme Title", new Game());
	}
}
