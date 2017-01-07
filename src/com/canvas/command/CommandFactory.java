package com.canvas.command;

import java.util.List;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.Command;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

public class CommandFactory {

	private static CommandFactory instance;

	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}

		return instance;
	}

	private CommandFactory() {
	}

	protected static final String CANVAS_COMMAND = "C";
	protected static final int CANVAS_EXPECTED_ARGS = 3;

	protected static final String LINE_COMMAND = "L";
	protected static final int LINE_EXPECTED_ARGS = 5;

	protected static final String RECTANGLE_COMMAND = "R";
	protected static final int RECTANGLE_EXPECTED_ARGS = 5;

	protected static final String BUCKET_FILL_COMMAND = "B";
	protected static final int BUCKET_FILL_EXPECTED_ARGS = 3;

	protected static final String QUIT_COMMAND = "Q";
	protected static final int QUIT_EXPECTED_ARGS = 1;

	public Command createCommand(String commandLine) {
		Command command;

		String firstLetter = commandLine.substring(0, 1);

		switch (firstLetter) {
		case (CANVAS_COMMAND):
			command = createCanvasCommand(commandLine);
			break;
		case (LINE_COMMAND):
			command = createLineCommand(commandLine);
			break;
		case (RECTANGLE_COMMAND):
			command = createRectangleCommand(commandLine);
			break;
		case (BUCKET_FILL_COMMAND):
			command = createBucketFillCommand(commandLine);
			break;
		case (QUIT_COMMAND):
			command = createQuitCommand(commandLine);
			break;
		default:
			command = new InvalidCommand(commandLine, "Invalid First Characater");
			break;
		}

		return command;
	}

	private Command createCanvasCommand(String commandLine) {
		List<String> errorMessages = CommandValidator.getInstance().validateSizeAndType(commandLine,
				CANVAS_EXPECTED_ARGS);
		;
		if (errorMessages.size() > 0) {
			return new InvalidCommand(commandLine, errorMessages);
		} else {
			return new CreateCanvasCommand(commandLine);
		}
	}

	private Command createLineCommand(String commandLine) {
		List<String> errorMessages = CommandValidator.getInstance().validateSizeAndType(commandLine,
				LINE_EXPECTED_ARGS);
		;
		if (errorMessages.size() > 0) {
			return new InvalidCommand(commandLine, errorMessages);
		} else {
			return new CreateLineCommand(commandLine);
		}
	}

	private Command createRectangleCommand(String commandLine) {
		List<String> errorMessages = CommandValidator.getInstance().validateSizeAndType(commandLine,
				RECTANGLE_EXPECTED_ARGS);
		;
		if (errorMessages.size() > 0) {
			return new InvalidCommand(commandLine, errorMessages);
		} else {
			return new CreateRectangleCommand(commandLine);
		}
	}

	private Command createBucketFillCommand(String commandLine) {
		List<String> errorMessages = CommandValidator.getInstance().validateSizeAndType(commandLine,
				BUCKET_FILL_EXPECTED_ARGS);
		;
		if (errorMessages.size() > 0) {
			return new InvalidCommand(commandLine, errorMessages);
		} else {
			return new BucketFillCommand(commandLine);
		}
	}

	private Command createQuitCommand(String commandLine) {
		List<String> errorMessages = CommandValidator.getInstance().validateSizeAndType(commandLine,
				QUIT_EXPECTED_ARGS);
		;
		if (errorMessages.size() > 0) {
			return new InvalidCommand(commandLine, errorMessages);
		} else {
			return new QuitCommand(commandLine);
		}
	}
}
