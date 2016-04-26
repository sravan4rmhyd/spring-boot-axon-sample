package com.sample.todo.app.domain.task.events;

public class TaskCompletedEvent implements TaskEvent {

	private  String id;

	public TaskCompletedEvent(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
