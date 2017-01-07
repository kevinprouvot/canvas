package com.canvas.command.model;

import com.canvas.command.CommandUtils;

public class CreateCanvasCommand extends Command {

	public CreateCanvasCommand(String commandLine) {
		super(commandLine, 3);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return CommandUtils.getInstance().validationInstructionSize(this);
	}

}
