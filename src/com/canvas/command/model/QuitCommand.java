package com.canvas.command.model;

public class QuitCommand extends Command {

	public QuitCommand(String commandLine) {
		super(commandLine, 1);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
