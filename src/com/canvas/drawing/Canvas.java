package com.canvas.drawing;

import java.io.PrintStream;

public class Canvas {
	private static final char HORIZONTAL_BAR = '-';
	private static final char VERTICAL_BAR = '|';
	private static final String LINE_SEPARATOR = System.lineSeparator();

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
		// Drawing top border
		for (int x = 0 ; x < weight + 2; x++) {
			output.print(HORIZONTAL_BAR);
		}
		output.print(LINE_SEPARATOR);
		
		// Drawing each line
		for (int y = 0 ; y < this.height ; y++) {
			output.print(VERTICAL_BAR);
			
			for (int x = 0 ; x < this.weight ; x++) {
				output.print(this.canvas[x][y]);
			}
			
			output.print(VERTICAL_BAR);
			output.print(LINE_SEPARATOR);
		}
		
		
		// Drawing bottom border
		for (int x = 0 ; x < weight + 2; x++) {
			output.print(HORIZONTAL_BAR);
		}
	}
}
