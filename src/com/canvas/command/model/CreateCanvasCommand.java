package com.canvas.command.model;

public class CreateCanvasCommand extends Command {

	private int w;
	private int h;

	public CreateCanvasCommand(String commandLine) {
		super(commandLine);

		String[] instruction = commandLine.split(" ");

		this.w = Integer.valueOf(instruction[1]);
		this.h = Integer.valueOf(instruction[2]);
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

}
