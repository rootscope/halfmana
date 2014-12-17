package net.rootscope.halfmana;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Component extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	public static int width = 1920 / 2;
	public static int height = 1080 / 2;
	public static int scale = 1;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	public Component(){
		frame = new JFrame();
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "component");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		while(running){
			tick();
			render();
		}
	}
	
	public void tick(){
		
	}
	
	public void render(){
		BufferStrategy bufferStrategy = getBufferStrategy();
		if(bufferStrategy == null){
			createBufferStrategy(3);
			return;
		}
	}
	
	public static void main(String[] args){
		Component component = new Component();

		component.frame.setResizable(false);
		component.frame.setTitle("halfmana");
		component.frame.add(component);
		component.frame.pack();
		component.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component.frame.setLocationRelativeTo(null);
		component.frame.setVisible(true);
		
		component.start();
	}

}
