package com.canvas.command.model;

public class Command {
	
	protected String commandLine;
	protected int instructionCount;
	
	public Command(String commandLine, int instructionCount) {
		this.commandLine = commandLine;
		this.instructionCount = instructionCount;
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
		return this.commandLine;
	}
	
	public int getInsctructionCount() {
		return this.instructionCount;
	}

}
