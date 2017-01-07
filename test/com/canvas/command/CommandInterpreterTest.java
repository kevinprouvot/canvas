package com.canvas.command;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.Command;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

public class CommandInterpreterTest {

	private CommandInterpreter commandInterpreter;
	private String inputText;
	private Command currentCommand;

	@Before
	public void setUp() throws Exception {
		commandInterpreter = new CommandInterpreter(null);
		// TODO create a valid/invalid command generator
	}

	@After
	public void tearDown() throws Exception {
	}

	// CORRECT INPUT

	@Test
	public void testCreateCanvasInput() {
		inputText = "C 4 5";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateCanvasCommand);

		CreateCanvasCommand createCanvasCommand = (CreateCanvasCommand)currentCommand;
		assertTrue("wrongly created Canvas command", createCanvasCommand.getW() == 4);
		assertTrue("wrongly created Canvas command", createCanvasCommand.getH() == 5);
		
		inputText = " C 4   5";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateCanvasCommand);
		
		createCanvasCommand = (CreateCanvasCommand)currentCommand;
		assertTrue("wrongly created Canvas command", createCanvasCommand.getW() == 4);
		assertTrue("wrongly created Canvas command", createCanvasCommand.getH() == 5);
		
		inputText = "C 12 5";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateCanvasCommand);
		
		createCanvasCommand = (CreateCanvasCommand)currentCommand;
		assertTrue("wrongly created Canvas command", createCanvasCommand.getW() == 12);
		assertTrue("wrongly created Canvas command", createCanvasCommand.getH() == 5);
	}

	@Test
	public void testCreateLineInput() {
		inputText = "L 1 2 1 4";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateLineCommand);
		
		CreateLineCommand createLineCommand = (CreateLineCommand)currentCommand;
		assertTrue("wrongly created Line command", createLineCommand.getX1() == 1);
		assertTrue("wrongly created Line command", createLineCommand.getY1() == 2);
		assertTrue("wrongly created Line command", createLineCommand.getX2() == 1);
		assertTrue("wrongly created Line command", createLineCommand.getY2() == 4);
		
		inputText = "L 12 0 12 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateLineCommand);
		
		createLineCommand = (CreateLineCommand)currentCommand;
		assertTrue("wrongly created Line command", createLineCommand.getX1() == 12);
		assertTrue("wrongly created Line command", createLineCommand.getY1() == 0);
		assertTrue("wrongly created Line command", createLineCommand.getX2() == 12);
		assertTrue("wrongly created Line command", createLineCommand.getY2() == 2);
	}

	@Test
	public void testCreateRectangleInput() {
		inputText = "R 0 1 2 3";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof CreateRectangleCommand);
		
		CreateRectangleCommand createRectangleCommand = (CreateRectangleCommand)currentCommand;
		assertTrue("wrongly created Line command", createRectangleCommand.getX1() == 0);
		assertTrue("wrongly created Line command", createRectangleCommand.getY1() == 1);
		assertTrue("wrongly created Line command", createRectangleCommand.getX2() == 2);
		assertTrue("wrongly created Line command", createRectangleCommand.getY2() == 3);
	}

	@Test
	public void testBucketFillInput() {
		inputText = "B 0 1 o";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof BucketFillCommand);
		
		BucketFillCommand bucketFillCommand = (BucketFillCommand)currentCommand;
		assertTrue("wrongly created Line command", bucketFillCommand.getX() == 0);
		assertTrue("wrongly created Line command", bucketFillCommand.getY() == 1);
		assertTrue("wrongly created Line command", bucketFillCommand.getColor() == 'o');
		
		inputText = "B 10 1 o";
		currentCommand = commandInterpreter.interpretCommand(inputText);
		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof BucketFillCommand);
	}

	@Test
	public void testQuitInput() {
		inputText = "Q";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof QuitCommand);
	}

	// INVALID INPUT

	@Test
	public void testInvalidFirstLetterInput() {
		inputText = "Z";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidCanvasParameter() {
		inputText = "C";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "C 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "C 2 4 3";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "C A 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "C2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidLineParameter() {
		inputText = "L";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "L 2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "L 2 2 2 4 3";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "L A 2 2 2 ";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "L2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidRectangleParameter() {
		inputText = "R";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "R 2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "R 2 2 2 4 3";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "R A 2 2 2 ";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "R2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidBucketFillParameter() {
		inputText = "B";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "B 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "B 2 2 2 4 3";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "B A 2 ";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);

		inputText = "B2 2";
		currentCommand = commandInterpreter.interpretCommand(inputText);

		assertTrue("Wrong command created. Text: " + inputText, currentCommand instanceof InvalidCommand);
	}
}
