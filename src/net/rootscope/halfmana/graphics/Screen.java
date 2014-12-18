package net.rootscope.halfmana.graphics;

import java.util.Random;

public class Screen{
	private int width;
	private int height;
	private Random random = new Random();
	
	public int[] pixels;
	public int[] tiles = new int[4096];
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < 4096; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void render(){
		for(int y = 0; y < height; y++){
			if(y >= height || y < 0) break;
			for(int x = 0; x < width; x++){
				if(x >= width || x < 0) break;
				int tileIndex = (x >> 4) + (y >> 4) * 64;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}

}
