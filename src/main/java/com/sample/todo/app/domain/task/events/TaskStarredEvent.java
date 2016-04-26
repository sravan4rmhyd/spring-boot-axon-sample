package com.sample.todo.app.domain.task.events;

public class TaskStarredEvent implements TaskEvent {

	private final String id;

	public TaskStarredEvent(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
