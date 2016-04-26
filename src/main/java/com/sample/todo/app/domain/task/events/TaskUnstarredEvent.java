package com.sample.todo.app.domain.task.events;

public class TaskUnstarredEvent implements TaskEvent {

	private final String id;

	public TaskUnstarredEvent(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
