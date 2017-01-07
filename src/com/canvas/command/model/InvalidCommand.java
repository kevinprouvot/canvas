package com.canvas.command.model;

public class InvalidCommand extends Command {

	public InvalidCommand(String commandLine) {
		super(commandLine, 0);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
