package com.canvas.command.model;

public class CreateLineCommand implements Command {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public CreateLineCommand(String commandLine) {
		
		String[] instruction = commandLine.split(" ");

		this.x1 = Integer.valueOf(instruction[1]);
		this.y1 = Integer.valueOf(instruction[2]);
		this.x2 = Integer.valueOf(instruction[3]);
		this.y2 = Integer.valueOf(instruction[4]);
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
	
	public static boolean validateVerticalHorizontalLine(CreateLineCommand lineCommand) {
		return lineCommand.getX1() == lineCommand.getX2() || lineCommand.getY1() == lineCommand.getY2();
	}

}
