package com.canvas.drawing;

import java.io.OutputStream;
import java.util.Queue;

import com.canvas.controller.shape.IShape;

/**
 * Drawing Factory will display drawing in the output
 * 
 */
public class DrawingFactory {

	private OutputStream output;

	public DrawingFactory(OutputStream outputStream) {
		this.output = outputStream;
	}

	public void draw(Queue<IShape> shapes) {

	}
}
