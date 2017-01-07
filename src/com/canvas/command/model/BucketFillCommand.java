package com.canvas.command.model;

public class BucketFillCommand extends Command {

	public BucketFillCommand(String commandLine) {
		super(commandLine);
	}

	@Override
	public void instantiate() {
		
	}
	
	@Override
	public boolean validate() {
		return false;
	}

}
