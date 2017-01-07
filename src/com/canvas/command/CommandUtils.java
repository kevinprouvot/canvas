package com.canvas.command;

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
}
