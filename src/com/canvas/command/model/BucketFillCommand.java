package com.canvas.command.model;

import com.canvas.command.CommandUtils;

public class BucketFillCommand extends Command {

	public BucketFillCommand(String commandLine) {
		super(commandLine, 4);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return CommandUtils.getInstance().validateSizeAndType(this);
	}

}
