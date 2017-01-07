package com.canvas.command.model;

import com.canvas.command.CommandUtils;

public class QuitCommand extends Command {

	public QuitCommand(String commandLine) {
		super(commandLine, 1);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return CommandUtils.getInstance().validationInstructionSize(this);
	}

}
