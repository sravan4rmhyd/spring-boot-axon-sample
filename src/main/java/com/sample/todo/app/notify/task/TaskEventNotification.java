package com.sample.todo.app.notify.task;

import com.sample.todo.app.domain.task.events.TaskEvent;


public class TaskEventNotification {
	
	private String type;
	
	private TaskEvent data;

	public TaskEventNotification(String type, TaskEvent data) {
		super();
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TaskEvent getData() {
		return data;
	}

	public void setData(TaskEvent data) {
		this.data = data;
	}
	
}
