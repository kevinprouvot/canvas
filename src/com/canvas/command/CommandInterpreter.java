package com.canvas.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.canvas.command.model.Command;

/**
 * Command interpreter will deduce which command to create depending on the
 * syntax provided by the input
 * 
 */
public class CommandInterpreter {

	private BufferedReader input;

	public CommandInterpreter(InputStream inputStream) {
		this.input = new BufferedReader(new InputStreamReader(inputStream));
	}

	public Command interpret() {
		String inputLine = readInput();
		String preparedInputLine = prepareCommandLine(inputLine);
		Command command = CommandFactory.getInstance().createCommand(preparedInputLine);
		return command;
	}

	private String readInput() {
		try {
			return input.readLine();
		} catch (IOException e) {
			System.err.println("Problem while reading input" + e);
			return "";
		}
	}

	private String prepareCommandLine(String inputLine) {
		inputLine = inputLine.trim();
		inputLine = inputLine.replaceAll("\\s+", " ");
		return inputLine;
	}
}
