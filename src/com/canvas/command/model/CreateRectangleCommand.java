package com.canvas.command.model;

import com.canvas.drawing.Canvas;

public class CreateRectangleCommand implements Command {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public CreateRectangleCommand(String commandLine) {
		
		String[] instruction = commandLine.split(" ");

		this.x1 = Integer.valueOf(instruction[1]);
		this.y1 = Integer.valueOf(instruction[2]);
		this.x2 = Integer.valueOf(instruction[3]);
		this.y2 = Integer.valueOf(instruction[4]);
		
		// Making sure that x1 is always the top left coordinate and y2 the bottom right
		if (x1 > x2) {
			int buffer = x1;
			x1 = x2;
			x2 = buffer;
		}
		
		if (y1 > y2) {
			int buffer = y1;
			y1 = y2;
			y2 = buffer;
		}
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	@Override
	public void apply(Canvas canvas) {
		// Top side
		for (int x = x1 ; x <= x2 ; x++) {
			canvas.setTile(x, y1, DEFAULT_COLOR);
		}
		// Bottom side
		for (int x = x1 ; x <= x2 ; x++) {
			canvas.setTile(x, y2, DEFAULT_COLOR);
		}
		// Left side
		for (int y = y1 ; y <= y2 ; y++) {
			canvas.setTile(x1, y, DEFAULT_COLOR);
		}
		// Right side
		for (int y = y1 ; y <= y2 ; y++) {
			canvas.setTile(x2, y, DEFAULT_COLOR);
		}
	}

}
