package com.canvas.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

import com.canvas.command.CommandInterpreter;
import com.canvas.command.model.Command;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;
import com.canvas.controller.ShapeController;
import com.canvas.controller.shape.IShape;
import com.canvas.drawing.DrawingFactory;

/**
 * Entry point of the application
 *
 */
public class CanvasMain {

	public static void main(String[] args) {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		CommandInterpreter commandInterpreter = new CommandInterpreter(input);
		ShapeController shapeController = new ShapeController();
		DrawingFactory drawingFactory = new DrawingFactory(System.out);

		// First Command interpretation
		Command command = commandInterpreter.interpret();

		// Main loop
		while (!(command instanceof QuitCommand)) {
			
			// If the command is invalid, display error message
			if (command instanceof InvalidCommand) {
				InvalidCommand invalidCommand = (InvalidCommand)command;
				drawingFactory.displayErrorMessage(invalidCommand.getMessages());
			}
			else {
				Queue<IShape> shapes = shapeController.queueNewShape(command);
	
				drawingFactory.draw(shapes);
			}

			// Interpret next command
			command = commandInterpreter.interpret();
		}

	}

}
