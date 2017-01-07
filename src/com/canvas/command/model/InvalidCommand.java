package com.canvas.command.model;

public class InvalidCommand extends Command {

	public InvalidCommand(String commandLine) {
		super(commandLine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
