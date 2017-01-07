package com.canvas.command;

import com.canvas.command.model.Command;

public class CommandUtils {
	
	private static CommandUtils instance;
	
	public static CommandUtils getInstance() {
		if (instance == null) {
			instance = new CommandUtils();
		}
		
		return instance;
	}
	
	private CommandUtils() { }
	
	public String[] getListOfInstrusction(String commandLine) {
		return commandLine.split(" ");
	}
	
	public boolean validationInstructionSize(Command command) {
		String[] instructions = getListOfInstrusction(command.getCommandLine());
		
		return instructions.length != command.getInsctructionCount();
	}
}
