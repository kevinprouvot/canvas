package com.canvas.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CommandValidator {

	private static CommandValidator instance;

	public static CommandValidator getInstance() {
		if (instance == null) {
			instance = new CommandValidator();
		}

		return instance;
	}

	private CommandValidator() {
	}

	public List<String> validateSizeAndType(String commandLine, int expectedInstructionCount) {
		List<String> errors = new ArrayList<>();

		String[] instructions = getListOfInstrusction(commandLine);

		String error = validationInstructionSize(instructions, expectedInstructionCount);
		if (error != null) {
			errors.add(error);
		}
		error = validateNumericParameter(instructions);
		if (error != null) {
			errors.add(error);
		}

		return errors;
	}

	public String[] getListOfInstrusction(String commandLine) {
		return commandLine.split(" ");
	}

	private String validationInstructionSize(String[] instructions, int instructionCount) {
		if (instructions.length != instructionCount) {
			return "Invalid number of parameter.";
		}
		return null;
	}

	private String validateNumericParameter(String[] instructions) {
		boolean validated = true;

		for (int i = 1; i < instructions.length; i++) {
			String instruction = instructions[i];

			validated = validated && StringUtils.isNumeric(instruction);
		}

		if (!validated) {
			return "Invalid parameter format.";
		}
		return null;
	}
}
