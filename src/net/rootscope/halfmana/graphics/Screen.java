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
			int yy = y;
			if(yy >= height || yy < 0) break;
			for(int x = 0; x < width; x++){
				int xx = x + 8;
				if(xx >= width || xx < 0) break;
				int tileIndex = ((xx >> 4) & 63) + ((yy >> 4) & 63) * 64;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}

}
