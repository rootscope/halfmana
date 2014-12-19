package net.rootscope.halfmana.graphics;

public class Sprite {
	private final int SIZE;
	private int x;
	private int y;  
	
	public int[] pixels;
	
	private SpriteSheet sheet;
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		
	}
}
