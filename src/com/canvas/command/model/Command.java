package com.canvas.command.model;

public class Command {
	
	protected String commandLine;
	
	public Command(String commandLine) {
		this.commandLine = commandLine;
	}
	
	public boolean validate() {
		return false;
	}

}
