package net.rootscope.halfmana.graphics;

import java.util.Random;

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
			int yy = y + yOff;
			//if(yy >= height || yy < 0) break;
			for(int x = 0; x < width; x++){
				int xx = x + xOff;
				//if(xx >= width || xx < 0) break;
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}

}
