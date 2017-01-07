package com.canvas.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

import com.canvas.command.CommandInterpreter;
import com.canvas.command.model.Command;
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

		Command command = commandInterpreter.interpret();

		while (!(command instanceof QuitCommand)) {
			Queue<IShape> shapes = shapeController.queueNewShape(command);

			drawingFactory.draw(shapes);

			command = commandInterpreter.interpret();
		}

	}

}
