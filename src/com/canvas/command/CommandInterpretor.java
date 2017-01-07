package com.canvas.command;

import java.io.InputStream;

import com.canvas.command.model.ICommand;

/**
 * Command interpretor will deduce what command to create depending on the
 * syntax
 * 
 */
public class CommandInterpretor {

	private InputStream input;
	
	public CommandInterpretor(InputStream inputStream) {
		this.input = inputStream;
	}
	
	public ICommand interpret() {
		return null;
	}
}
