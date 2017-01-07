package com.canvas.command.model;

public class Command {
	
	protected String commandLine;
	
	public Command(String commandLine) {
		this.commandLine = commandLine;
	}
	
	/**
	 * Try to instantiate the command given the command
	 * @return instantiation status
	 */
	public void instantiate() {
		
	}
	
	public boolean validate() {
		return false;
	}
	
	public String getCommandLine() {
		return commandLine;
	}

}
