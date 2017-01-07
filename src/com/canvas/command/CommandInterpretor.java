package com.canvas.command;

import java.io.BufferedReader;
import java.io.IOException;

import com.canvas.command.model.ICommand;

/**
 * Command interpretor will deduce what command to create depending on the
 * syntax
 * 
 */
public class CommandInterpretor {

	private BufferedReader input;
	private String inputLine;

	public CommandInterpretor(BufferedReader bufferedReader) {
		this.input = bufferedReader;
	}

	public ICommand interpret() {
		return null;
	}

	private void readInput() {
		try {
			inputLine = input.readLine();
		} catch (IOException e) {
			// TODO LOGGING ERROR
		}
	}

	// TEST METHODS
	
	protected void setInputLine(String line) {
		this.inputLine = line;
	}
}
