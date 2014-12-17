package net.rootscope.halfmana;

public class Component implements Runnable{
	
	public static int width = 1920 / 2;
	public static int height = 1080 / 2;
	
	private Thread thread;
	
	public synchronized void start(){
		thread = new Thread(this, "component");
		thread.start();
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
	}

}
