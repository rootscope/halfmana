package net.rootscope.halfmana.graphics;

public class Screen{
	private int width;
	private int height;
	
	public int[] pixels;
	
	int time;
	int count;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void render(){
		count++;
		if(count % 10 == 0){
			time++;
		}
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				pixels[time + time * width] = 0xff00ff;
			}
		}

	}

}
