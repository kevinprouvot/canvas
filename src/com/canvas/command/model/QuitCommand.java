package com.canvas.command.model;

public class QuitCommand extends Command {

	public QuitCommand(String commandLine) {
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
