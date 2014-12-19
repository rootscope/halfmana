package net.rootscope.halfmana.level;

import net.rootscope.halfmana.graphics.Screen;

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
	
	public void tick(){
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		
	}
	
	private void time(){
		
	}
	
	private void generateLevel(){
		
	}
	
	private void loadLevel(String path){
		
	}

}
