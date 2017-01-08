package com.canvas.command.model;

public class CreateCanvasCommand implements Command {

	private int weight;
	private int height;

	public CreateCanvasCommand(String commandLine) {

		String[] instruction = commandLine.split(" ");

		this.weight = Integer.valueOf(instruction[1]);
		this.height = Integer.valueOf(instruction[2]);
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public char[][] buildCanvas() {
		char[][] canvas = new char[this.weight][this.height];
		
		for (int x = 0 ; x < this.weight ; x++) {
			for (int y = 0 ; y < this.height ; y ++) {
				canvas[x][y] = ' ';
			}
		}
		
		return canvas;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
	}
	
}
