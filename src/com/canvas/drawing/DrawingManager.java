package com.canvas.drawing;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.canvas.command.model.Command;
import com.canvas.command.model.CreateCanvasCommand;

public class DrawingManager {

	private char[][] canvas;
	private List<Command> commands;
	private PrintStream output;

	public DrawingManager(PrintStream output) {
		this.commands = new ArrayList<>();
		// Default canvas is 20x4
		this.canvas = new char[20][4];
		this.output = output;
	}

	public void displayErrorMessage(List<String> errorMessages) {
		for (String errorMessage : errorMessages) {
			output.println(errorMessage);
		}
	}

	public void queueCommand(Command command) {
		if (command instanceof CreateCanvasCommand) {
			CreateCanvasCommand createCanvasCommand = (CreateCanvasCommand) command;
			resetCanvas(createCanvasCommand);
		} else {
			commands.add(command);
			applyCommand(command);
		}
	}

	public void draw() {

	}

	private void resetCanvas(CreateCanvasCommand createCanvasCommand) {
		this.commands = new ArrayList<>();
		this.commands.add(createCanvasCommand);
		this.canvas = createCanvasCommand.buildCanvas();
	}

	private void applyCommand(Command command) {

	}

}
