package com.canvas.command.model;

import com.canvas.drawing.Canvas;

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
	
	public Canvas buildCanvas() {
		return new Canvas(this.weight, this.height);
	}

	@Override
	public void apply(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
	
}
