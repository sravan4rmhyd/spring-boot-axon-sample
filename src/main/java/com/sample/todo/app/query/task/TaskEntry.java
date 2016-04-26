package com.sample.todo.app.query.task;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "tasks", type = "entry")
@Table
public class TaskEntry {

	@Id
	private String id;
	private String username;
	private String title;
	private boolean completed;
	private boolean starred;
	public TaskEntry()
	{
		
	}
	public TaskEntry(String id, String username, String title, boolean completed, boolean starred) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.completed = completed;
		this.starred = starred;
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
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public boolean isStarred() {
		return starred;
	}
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	
}