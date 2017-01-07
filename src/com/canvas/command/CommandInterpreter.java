package com.canvas.command;

import java.io.BufferedReader;
import java.io.IOException;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.Command;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

/**
 * Command interpreter will deduce what command to create depending on the
 * syntax
 * 
 */
public class CommandInterpreter {

	private BufferedReader input;
	private String inputLine;

	protected static final String CANVAS_COMMAND = "C";
	protected static final String LINE_COMMAND = "L";
	protected static final String RECTANGE_COMMAND = "R";
	protected static final String BUCKET_FILL_COMMAND = "B";
	protected static final String QUIT_COMMAND = "Q";

	public CommandInterpreter(BufferedReader bufferedReader) {
		this.input = bufferedReader;
	}

	public Command interpret() {
		// TODO Create a separate class for the reader
		inputLine = readInput();
		return interpretCommand();
	}

	protected Command interpretCommand() {
		String commandLine = prepareCommandLine(inputLine);
		Command command = createCommand(commandLine);
		command = instantiateCommand(command);
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

	private Command createCommand(String commandLine) {
		Command command;

		String firstLetter = commandLine.substring(0, 1);

		switch (firstLetter) {
		case (CANVAS_COMMAND):
			command = new CreateCanvasCommand(commandLine);
			break;
		case (LINE_COMMAND):
			command = new CreateLineCommand(commandLine);
			break;
		case (RECTANGE_COMMAND):
			command = new CreateRectangleCommand(commandLine);
			break;
		case (BUCKET_FILL_COMMAND):
			command = new BucketFillCommand(commandLine);
			break;
		case (QUIT_COMMAND):
			command = new QuitCommand(commandLine);
			break;
		default:
			command = new InvalidCommand(commandLine);
			break;
		}

		return command;
	}

	private Command instantiateCommand(Command command) {
		if (command.validate()) {
			command.instantiate();
		} else {
			// TODO Add error message for invalid commands
			command = new InvalidCommand(command.getCommandLine());
		}

		return command;

	}

	// TEST METHODS

	protected void setInputLine(String line) {
		this.inputLine = line;
	}
}
