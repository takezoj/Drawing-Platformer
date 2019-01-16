package com.takezo.platformer.window;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -6735838867349853418L;

	private boolean running = false;
	private Thread thread;
	
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() 
	{
		System.out.println("Game has begun");
	}
	
	public static void main(String[] args)
	{
		new Window(800, 600, "Dis a Gayme Title", new Game());
	}
}
