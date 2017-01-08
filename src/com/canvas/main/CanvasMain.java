package com.canvas.main;

import java.io.InputStream;
import java.io.PrintStream;

import com.canvas.command.CommandInterpreter;
import com.canvas.command.model.Command;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;
import com.canvas.drawing.DrawingManager;

/**
 * Entry point of the application
 *
 */
public class CanvasMain {

	public static void main(String[] args) {

		// Setting input
		InputStream input = System.in;
		CommandInterpreter commandInterpreter = new CommandInterpreter(input);
		
		//Setting ouput
		PrintStream output = System.out;
		DrawingManager drawingManager = new DrawingManager(output);

		// First Command interpretation
		Command command = commandInterpreter.interpret();

		// Main loop
		while (!(command instanceof QuitCommand)) {
			
			if (command instanceof InvalidCommand) {
				InvalidCommand invalidCommand = (InvalidCommand) command;
				drawingManager.displayErrorMessage(invalidCommand.getMessages());
			} else {
				drawingManager.queueCommand(command);		
				drawingManager.draw();
			}

			// Interpret next command
			command = commandInterpreter.interpret();
		}

	}

}
