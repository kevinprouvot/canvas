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
			command = createShapeCommand(commandLine, CANVAS_REGEX, CreateCanvasCommand.class);
			break;
		case (LINE_COMMAND):
			command = createShapeCommand(commandLine, LINE_REGEX, CreateLineCommand.class);
			break;
		case (RECTANGLE_COMMAND):
			command = createShapeCommand(commandLine, RECTANGLE_REGEX, CreateRectangleCommand.class);
			break;
		case (BUCKET_FILL_COMMAND):
			command = createShapeCommand(commandLine, BUCKET_FILL_REGEX, BucketFillCommand.class);
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

	private Command createShapeCommand(String commandLine, String pattern, Class<? extends Command> shapeClass) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(commandLine);
		if (m.matches()) {
			try {
				return shapeClass.getConstructor(String.class).newInstance(commandLine);
			} catch (IllegalAccessException | NoSuchMethodException | InstantiationException
					| InvocationTargetException e) {
				return new InvalidCommand(commandLine, "Unexpected error");
			}
		} else {
			return new InvalidCommand(commandLine, "Invalid Pararmeters");
		}

	}

	private Command createQuitCommand(String commandLine) {
		return new QuitCommand(commandLine);
	}
}
