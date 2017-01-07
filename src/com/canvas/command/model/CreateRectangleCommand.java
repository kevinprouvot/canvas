package com.canvas.command.model;

public class CreateRectangleCommand extends Command {

	public CreateRectangleCommand(String commandLine) {
		super(commandLine, 5);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
