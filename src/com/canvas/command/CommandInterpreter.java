package com.canvas.command;

import java.io.BufferedReader;
import java.io.IOException;

import com.canvas.command.model.Command;

/**
 * Command interpreter will deduce what command to create depending on the
 * syntax
 * 
 */
public class CommandInterpreter {

	private BufferedReader input;

	public CommandInterpreter(BufferedReader bufferedReader) {
		this.input = bufferedReader;
	}

	public Command interpret() {
		String inputLine = readInput();
		return interpretCommand(inputLine);
	}

	protected Command interpretCommand(String inputLine) {
		String preparedInputLine = prepareCommandLine(inputLine);
		Command command = CommandFactory.getInstance().createCommand(preparedInputLine);
		return command;
	}

	private String readInput() {
		try {
			return input.readLine();
		} catch (IOException e) {
			// TODO LOGGING ERROR
			return "";
		}
	}

	private String prepareCommandLine(String inputLine) {
		return inputLine.trim();
	}
}
