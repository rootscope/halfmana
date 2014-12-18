package net.rootscope.halfmana.graphics;

public class Screen{
	private int width;
	private int height;
	
	public int[] pixels;
	
	int xtime = 0, ytime = 0;
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
		if(count % 10 == 0) xtime++;
		if(count % 10 == 0) ytime++;
		for(int y = 0; y < height; y++){
			if(ytime >= height || ytime < 0) break;
			for(int x = 0; x < width; x++){
				if(xtime >= width || xtime < 0) break;
				pixels[xtime + ytime * width] = 0xff00ff;
			}
		}

	}

}
