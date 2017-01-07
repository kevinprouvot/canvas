package com.canvas.command;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.Command;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

public class CommandInterpreterTest {

	private CommandInterpreter commandInterpreter;
	private String inputText;
	private Command currentComand;

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
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateCanvasCommand);

		inputText = " C 4   5";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateCanvasCommand);
		
		inputText = "C 12 5";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateCanvasCommand);
	}

	@Test
	public void testCreateLineInput() {
		inputText = "L 1 0 1 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateLineCommand);
		
		inputText = "L 12 0 12 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateLineCommand);
	}

	@Test
	public void testCreateRectangleInput() {
		inputText = "R 0 0 2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateRectangleCommand);
		
		inputText = "R 10 0 2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateRectangleCommand);
	}

	@Test
	public void testBucketFillInput() {
		inputText = "B 1 1 o";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof BucketFillCommand);
		
		inputText = "B 10 1 o";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof BucketFillCommand);
	}

	@Test
	public void testQuitInput() {
		inputText = "Q";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof QuitCommand);
	}

	// INVALID INPUT

	@Test
	public void testInvalidFirstLetterInput() {
		inputText = "Z";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidCanvasParameter() {
		inputText = "C";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C 2 4 3";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C A 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidLineParameter() {
		inputText = "L";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L 2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L 2 2 2 4 3";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L A 2 2 2 ";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidRectangleParameter() {
		inputText = "R";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R 2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R 2 2 2 4 3";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R A 2 2 2 ";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidBucketFillParameter() {
		inputText = "B";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B 2 2 2 4 3";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B A 2 ";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B2 2";
		commandInterpreter.setInputLine(inputText);
		currentComand = commandInterpreter.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}
}
