package com.canvas.command.model;

public class CreateLineCommand extends Command {

	public CreateLineCommand(String commandLine) {
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
