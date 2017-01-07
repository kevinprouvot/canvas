package com.canvas.command.model;

public class CreateRectangleCommand extends Command {

	public CreateRectangleCommand(String commandLine) {
		super(commandLine);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
