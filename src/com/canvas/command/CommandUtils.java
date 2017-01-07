package com.canvas.command;

import org.apache.commons.lang3.StringUtils;

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
	
	public boolean validateSizeAndType(Command command) {
		String[] instructions = getListOfInstrusction(command.getCommandLine());
		
		return validationInstructionSize(command, instructions) &&
				validateNumericParameter(command, instructions);
	}
	
	public String[] getListOfInstrusction(String commandLine) {
		return commandLine.split(" ");
	}
	
	// VALIDATION METHODS
	
	private boolean validationInstructionSize(Command command, String[] instructions) {
		return instructions.length != command.getInsctructionCount();
	}
	
	private boolean validateNumericParameter(Command command, String[] instructions) {
		boolean result = true;
		
		for (int i = 1 ; i < instructions.length ; i++) {
			String instruction = instructions[i];
			
			result = result && StringUtils.isNumeric(instruction);
		}
		
		return result;
	}
}
