package net.rootscope.halfmana;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import net.rootscope.halfmana.graphics.Screen;

public class Component extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	public static int width = 960 / 2;
	public static int height = 540 / 2;
	public static int scale = 2;
	
	public static String title = "halfmana";
	
	private boolean running = false;
	private Thread thread;
	private JFrame frame;
	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Component(){
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
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
		long timex = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long time = System.nanoTime();
			delta += (time - timex) / ns;
			timex = time;
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(title + " [fps = " + frames + "]");
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	public void tick(){
		
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render();
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		//

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		//
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		Component component = new Component();

		component.frame.setResizable(false);
		component.frame.setTitle(title);
		component.frame.add(component);
		component.frame.pack();
		component.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component.frame.setLocationRelativeTo(null);
		component.frame.setVisible(true);
		
		component.start();
	}

}
