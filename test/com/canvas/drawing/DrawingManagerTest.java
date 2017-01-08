package com.canvas.drawing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;

public class DrawingManagerTest {
	
	private DrawingManager drawingManager;
	private ByteArrayOutputStream output;
	
	private static final String LINE_SEP = System.lineSeparator();
	@Before
	public void setUp() throws Exception {
		output = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(output);
		drawingManager = new DrawingManager(printStream);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDisplaySimpleCanvas() {
		
		String expectedResult = 
				"----" + LINE_SEP +
				"|  |" + LINE_SEP +
				"|  |" + LINE_SEP +
				"|  |" + LINE_SEP +
				"----";			
		
		drawingManager.queueCommand(new CreateCanvasCommand("C 2 3"));
		drawingManager.draw();
		assertTrue("Simple canvas output doesn't match  : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}
	
	@Test
	public void testDisplayDefaultCanvas() {
		
		String expectedResult = 
				"----------------------" + LINE_SEP +
				"|                    |" + LINE_SEP +
				"|xxxxxx              |" + LINE_SEP +
				"|                    |" + LINE_SEP +
				"|                    |" + LINE_SEP + 
				"----------------------";
		
		drawingManager.queueCommand(new CreateLineCommand("L 1 2 6 2"));
		drawingManager.draw();
		
		assertTrue("Default canvas output doesn't match : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}
	
	@Test
	public void testDrawOutOfTheCanvas() {
		String expectedResult = 
				"----------------------" + LINE_SEP +
				"|                    |" + LINE_SEP +
				"|xxxxxxxxxxxxxxxxxxxx|" + LINE_SEP +
				"|                    |" + LINE_SEP +
				"|                    |" + LINE_SEP + 
				"----------------------";
		
		drawingManager.queueCommand(new CreateLineCommand("L 1 2 24 2"));
		drawingManager.draw();
		
		assertTrue("out of the canvas drawing output doesn't match : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}
	
	@Test
	public void testDisplayRectangle() {
		String expectedResult = 
				"----------------------" + LINE_SEP +
				"|               xxxxx|" + LINE_SEP +
				"|               x   x|" + LINE_SEP +
				"|               xxxxx|" + LINE_SEP +
				"|                    |" + LINE_SEP + 
				"----------------------";
		
		drawingManager.queueCommand(new CreateRectangleCommand("R 16 1 20 3"));
		drawingManager.draw();
		
		assertTrue("Rectangle drawing output doesn't match : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}
	
	@Test
	public void testDisplayBucketFill() {
		String expectedResult = 
				"----------------------" + LINE_SEP +
				"|xxxxxxxxxxxxxxxxxxxx|" + LINE_SEP +
				"|xxxxxxxxxxxxxxxx   x|" + LINE_SEP +
				"|xxxxxxxxxxxxxxxxxxxx|" + LINE_SEP +
				"|xxxxxxxxxxxxxxxxxxxx|" + LINE_SEP + 
				"----------------------";
		
		drawingManager.queueCommand(new CreateRectangleCommand("R 16 1 20 3"));
		drawingManager.queueCommand(new BucketFillCommand("B 16 1 x"));
		drawingManager.draw();
		
		assertTrue("Bucket Fill tool output doesn't match : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}
	
	@Test
	public void testDisplayMainCanvas() {;
	
		String expectedResult = 
				"----------------------" + LINE_SEP +
				"|oooooooooooooooxxxxx|" + LINE_SEP +
				"|xxxxxxooooooooox   x|" + LINE_SEP +
				"|     xoooooooooxxxxx|" + LINE_SEP +
				"|     xoooooooooooooo|" + LINE_SEP + 
				"----------------------";
	
		drawingManager.queueCommand(new CreateCanvasCommand("C 20 4"));
		
		drawingManager.queueCommand(new CreateLineCommand("L 6 3 6 4"));
		drawingManager.queueCommand(new CreateRectangleCommand("R 16 1 20 3"));
		drawingManager.queueCommand(new BucketFillCommand("B 10 3 o"));

		drawingManager.draw();
		assertTrue("Main canvas output doesn't match : " + LINE_SEP + output.toString(), expectedResult.equals(output.toString()));
	}

}
