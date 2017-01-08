package com.canvas.command.model;

import com.canvas.drawing.Canvas;

public class BucketFillCommand implements Command {

	private int x;
	private int y;
	private char color;

	public BucketFillCommand(String commandLine) {
		String[] instruction = commandLine.split(" ");

		this.x = Integer.valueOf(instruction[1]);
		this.y = Integer.valueOf(instruction[2]);
		this.color = instruction[3].charAt(0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getColor() {
		return color;
	}

	@Override
	public void apply(Canvas canvas) {
		char localColor = canvas.getTileColor(this.x, this.y);
		if (localColor != this.color) {
			fill_rec(canvas, this.x, this.y, localColor);
		}
	}
	
	private void fill_rec(Canvas canvas, int xDest, int yDest, char localColor) {
		if (canvas.isValidCoord(xDest, yDest) && canvas.getTileColor(xDest, yDest) == localColor) {
			canvas.setTile(xDest, yDest, this.color);
			fill_rec(canvas, xDest + 1, yDest, localColor);
			fill_rec(canvas, xDest, yDest + 1, localColor);
			fill_rec(canvas, xDest - 1, yDest, localColor);
			fill_rec(canvas, xDest, yDest - 1, localColor);
		}
	}

}
