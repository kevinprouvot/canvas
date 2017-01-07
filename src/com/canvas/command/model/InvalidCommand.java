package com.canvas.command.model;

public class InvalidCommand extends Command {
	
	private String message;

	public InvalidCommand(String commandLine) {
		super(commandLine, 0);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return true;
	}
	
	public String getMessage() {
		return this.message;
	}

}
