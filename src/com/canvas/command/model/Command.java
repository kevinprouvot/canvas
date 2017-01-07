package com.canvas.command.model;

public class Command {
	
	private String commandLine;
	
	public Command(String commandLine) {
		this.commandLine = commandLine;
	}
	
	public boolean validate() {
		return false;
	}

}
