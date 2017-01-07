package com.canvas.command.model;

import java.util.ArrayList;
import java.util.List;

public class InvalidCommand extends Command {
	
	private List<String> messages;

	public InvalidCommand(String commandLine, String message) {
		super(commandLine);
		
		this.messages = new ArrayList<>();
		this.messages.add(message);
	}
	
	public InvalidCommand(String commandLine, List<String> messages) {
		super(commandLine);
		this.messages = messages;
	}
	
	public List<String> getMessages() {
		return this.messages;
	}

}
