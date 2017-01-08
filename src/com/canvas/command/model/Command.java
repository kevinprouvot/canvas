package com.canvas.command.model;

import com.canvas.drawing.Canvas;

public interface Command {
	
	public static final char DEFAULT_COLOR = 'x';

	public void apply(Canvas canvas);
}
