package com.canvas.command.model;

import com.canvas.drawing.Canvas;

public interface Command {

	public void apply(Canvas canvas);
}
