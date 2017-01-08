package com.canvas.command.model;

import java.util.ArrayList;
import java.util.List;

import com.canvas.drawing.Canvas;

public class InvalidCommand implements Command {

	private List<String> messages;

	public InvalidCommand(String message) {

		this.messages = new ArrayList<>();
		this.messages.add(message);
	}

	public InvalidCommand(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return this.messages;
	}

	@Override
	public void apply(Canvas canvas) {
	}

}
