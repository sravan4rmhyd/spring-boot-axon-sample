package com.sample.todo.app.domain.task.events;

public class TaskCreatedEvent implements TaskEvent {

	private  String id;
	
	private  String username;
	
	private  String title;

	public TaskCreatedEvent(String id, String username, String title) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
