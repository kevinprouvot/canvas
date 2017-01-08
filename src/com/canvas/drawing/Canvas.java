package com.canvas.drawing;

import java.io.PrintStream;

public class Canvas {

	private char[][] canvas;
	private int weight = 0;
	private int height = 0;
	
	public Canvas(int weight, int height) {
		this.canvas = new char[weight][height];
		this.weight = weight;
		this.height = height;
		
		for (int x = 0 ; x < weight ; x++) {
			for (int y = 0 ; y < height ; y ++) {
				canvas[x][y] = ' ';
			}
		}
	}
	
	public void setTile(int x, int y, char color) {
		if (x >= 0 && x < this.weight && y >= 0 && y < this.height) {
			canvas[x][y] = color;
		}
	}
	
	public void draw(PrintStream output) {
		
	}
}
