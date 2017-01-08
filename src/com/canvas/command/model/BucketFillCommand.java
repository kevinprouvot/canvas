package com.canvas.command.model;

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
	public void apply() {
		// TODO Auto-generated method stub
		
	}

}
