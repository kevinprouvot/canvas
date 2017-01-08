package com.canvas.command;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.Command;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

public class CommandFactory {

	protected static final String CANVAS_COMMAND = "C";
	protected static final String CANVAS_REGEX = "^C \\d+ \\d+$";

	protected static final String LINE_COMMAND = "L";
	protected static final String LINE_REGEX = "^L \\d+ \\d+ \\d+ \\d+$";

	protected static final String RECTANGLE_COMMAND = "R";
	protected static final String RECTANGLE_REGEX = "^R \\d+ \\d+ \\d+ \\d+$";

	protected static final String BUCKET_FILL_COMMAND = "B";
	protected static final String BUCKET_FILL_REGEX = "^B \\d+ \\d+ \\w+$";

	protected static final String QUIT_COMMAND = "Q";
	protected static final String QUIT_REGEX = "^Q$";

	public Command createCommand(String commandLine) {
		Command command;

		String firstLetter = commandLine.substring(0, 1);

		switch (firstLetter) {
		case (CANVAS_COMMAND):
			command = tryCreateCanvasCommand(commandLine);
			break;
		case (LINE_COMMAND):
			command = tryCreateLineCommand(commandLine);
			break;
		case (RECTANGLE_COMMAND):
			command = tryCreateRectangleCommand(commandLine);
			break;
		case (BUCKET_FILL_COMMAND):
			command = tryCreateBucketFillCommand(commandLine);
			break;
		case (QUIT_COMMAND):
			command = createQuitCommand(commandLine);
			break;
		default:
			command = new InvalidCommand("Invalid command");
			break;
		}

		return command;
	}
	
	// Canvas Command
	private Command tryCreateCanvasCommand(String commandLine) {
		return tryCreateCommand(commandLine, CANVAS_REGEX, CreateCanvasCommand.class);
	}
	
	// Line Command
	private Command tryCreateLineCommand(String commandLine) {
		Command command = tryCreateCommand(commandLine, LINE_REGEX, CreateLineCommand.class);
		if (command instanceof CreateLineCommand) {
			CreateLineCommand lineCommand = (CreateLineCommand) command;
			if (!CreateLineCommand.validateVerticalHorizontalLine(lineCommand)) {
				command = new InvalidCommand("Application only support vertical or horizontal lines");
			}
		}
		
		return command;
	}
	
	// Rectangle command
	private Command tryCreateRectangleCommand(String commandLine) {
		return tryCreateCommand(commandLine, RECTANGLE_REGEX, CreateRectangleCommand.class);
	}
	
	// Bucket fill command
	private Command tryCreateBucketFillCommand(String commandLine) {
		return tryCreateCommand(commandLine, BUCKET_FILL_REGEX, BucketFillCommand.class);
	}
	
	
	private Command tryCreateCommand(String commandLine, String pattern, Class<? extends Command> commandClass) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(commandLine);
		if (m.matches()) {
			return createCommand(commandLine, commandClass);
		} else {
			return new InvalidCommand("Invalid Pararmeters");
		}
	}
	
	// Generic command constructor
	private Command createCommand(String commandLine, Class<? extends Command> commandClass) {
		try {
			return commandClass.getConstructor(String.class).newInstance(commandLine);
		} catch (IllegalAccessException | NoSuchMethodException | InstantiationException
				| InvocationTargetException e) {
			System.err.println("Error while Constructing Command " + e);
			return new InvalidCommand("Unexpected error");
		}
	}

	// Quit Command
	private Command createQuitCommand(String commandLine) {
		return new QuitCommand();
	}
}
