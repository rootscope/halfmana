package net.rootscope.halfmana.level.tile;

import net.rootscope.halfmana.graphics.Screen;
import net.rootscope.halfmana.graphics.Sprite;

public class Tile{
	public int x;
	public int y;
	public Sprite sprite;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}

}
