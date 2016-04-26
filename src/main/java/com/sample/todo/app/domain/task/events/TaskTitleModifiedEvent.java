package com.sample.todo.app.domain.task.events;

public class TaskTitleModifiedEvent implements TaskEvent {

	private final String id;
	
	private final String title;

	public TaskTitleModifiedEvent(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
}
