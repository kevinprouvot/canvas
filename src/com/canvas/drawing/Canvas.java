package com.canvas.drawing;

import java.io.PrintStream;

public class Canvas {

	private char[][] canvas;
	
	public Canvas(int weight, int height) {
		this.canvas = new char[weight][height];
		
		for (int x = 0 ; x < weight ; x++) {
			for (int y = 0 ; y < height ; y ++) {
				canvas[x][y] = ' ';
			}
		}
	}
	
	public void draw(PrintStream output) {
		
	}
}
