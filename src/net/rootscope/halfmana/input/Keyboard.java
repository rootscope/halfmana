package net.rootscope.halfmana.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	private boolean[] keys = new boolean[120]; // 65536 max
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	public void tick(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
