package com.canvas.command.model;

public class CreateLineCommand extends Command {

	public CreateLineCommand(String commandLine) {
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
