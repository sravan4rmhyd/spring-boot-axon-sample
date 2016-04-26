package com.sample.todo.app.domain.task;

public class TaskAlreadyCompletedException extends RuntimeException {

	private static final long serialVersionUID = 1518440584190922771L;

	public TaskAlreadyCompletedException(String message) {
		super(message);
	}
}
