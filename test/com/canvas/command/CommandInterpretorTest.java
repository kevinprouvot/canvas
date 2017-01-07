package com.canvas.command;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canvas.command.model.BucketFillCommand;
import com.canvas.command.model.CreateCanvasCommand;
import com.canvas.command.model.CreateLineCommand;
import com.canvas.command.model.CreateRectangleCommand;
import com.canvas.command.model.ICommand;
import com.canvas.command.model.InvalidCommand;
import com.canvas.command.model.QuitCommand;

public class CommandInterpretorTest {

	private CommandInterpretor commandInterpretor;
	private String inputText;
	private ICommand currentComand;

	@Before
	public void setUp() throws Exception {
		commandInterpretor = new CommandInterpretor(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	// CORRECT INPUT

	@Test
	public void testCreateCanvasInput() {
		inputText = "C 4 5";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateCanvasCommand);
		
		inputText = " C 4   5";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateCanvasCommand);
	}

	@Test
	public void testCreateLineInput() {
		inputText = "L 1 0 1 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateLineCommand);
	}

	@Test
	public void testCreateRectangleInput() {
		inputText = "R 0 0 2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof CreateRectangleCommand);
	}

	@Test
	public void testBucketFillInput() {
		inputText = "B 1 1 o";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof BucketFillCommand);
	}

	@Test
	public void testQuitInput() {
		inputText = "Q";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof QuitCommand);
	}

	// INVALID INPUT

	@Test
	public void testInvalidFirstLetterInput() {
		inputText = "Z";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}

	@Test
	public void testInvalidCanvasParameter() {
		inputText = "C";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C 2 4 3";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C A 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "C2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}
	
	@Test
	public void testInvalidLineParameter() {
		inputText = "L";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L 2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L 2 2 2 4 3";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L A 2 2 2 ";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "L2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}
	
	@Test
	public void testInvalidRectangleParameter() {
		inputText = "R";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R 2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R 2 2 2 4 3";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R A 2 2 2 ";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "R2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}
	
	@Test
	public void testInvalidBucketFillParameter() {
		inputText = "B";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B 2 2 2 4 3";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B A 2 ";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);

		inputText = "B2 2";
		commandInterpretor.setInputLine(inputText);
		currentComand = commandInterpretor.interpretCommand();

		assertTrue("Wrong command created. Text: " + inputText, currentComand instanceof InvalidCommand);
	}
}
