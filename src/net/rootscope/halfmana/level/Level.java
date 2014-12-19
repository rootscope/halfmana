package net.rootscope.halfmana.level;

public class Level{
	private int width;
	private int height; 
	private int[] sprites;
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		sprites = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
	}
	
	private void generateLevel(){
		
	}
	
	private void loadLevel(String path){
		
	}

}
