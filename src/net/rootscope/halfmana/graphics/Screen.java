package net.rootscope.halfmana.graphics;

import java.util.Random;

import net.rootscope.halfmana.level.tile.Tile;

public class Screen{
	private int width;
	private int height;
	private Random random = new Random();
	
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void render(int xOff, int yOff){
		for(int y = 0; y < height; y++){
			int yPix = y + yOff;
			if(yPix < 0 || yPix >= height) continue;
			for(int x = 0; x < width; x++){
				int xPix = x + xOff;
				if(xPix < 0 || xPix >= width) continue;
				pixels[xPix + yPix * width] = Sprite.grass.pixels[(x & 15) + ( y & 15) * Sprite.grass.SIZE];
			}
		}

	}
	
	public void renderTile(int xPos, int yPos, Tile tile){
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int yAbs = yPos + y;
			
		}
		
	}

}
