package com.canvas.command.model;

public class CreateCanvasCommand extends Command {

	public CreateCanvasCommand(String commandLine) {
		super(commandLine, 3);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
