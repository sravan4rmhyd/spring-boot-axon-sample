package com.sample.todo.app.query.task;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.todo.app.domain.task.events.TaskCompletedEvent;
import com.sample.todo.app.domain.task.events.TaskCreatedEvent;
import com.sample.todo.app.domain.task.events.TaskStarredEvent;
import com.sample.todo.app.domain.task.events.TaskTitleModifiedEvent;
import com.sample.todo.app.domain.task.events.TaskUnstarredEvent;

@Component
public class TaskEntryUpdatingEventHandler {

	private final TaskEntryRepository taskEntryRepository;
	
	@Autowired
	public TaskEntryUpdatingEventHandler(TaskEntryRepository taskEntryRepository) {
		this.taskEntryRepository = taskEntryRepository;
	}
	
	@EventHandler
	void on(TaskCreatedEvent event) {
		TaskEntry task = new TaskEntry(event.getId(), event.getUsername(), event.getTitle(), false, false);
		taskEntryRepository.save(task);
	}

	@EventHandler
	void on(TaskCompletedEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setCompleted(true);
		
		taskEntryRepository.save(task);
	}
	
	@EventHandler
	void on(TaskTitleModifiedEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setTitle(event.getTitle());
		
		taskEntryRepository.save(task);
	}
	
	@EventHandler
	void on (TaskStarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setStarred(true);
		
		taskEntryRepository.save(task);
	}
	
	@EventHandler
	void on (TaskUnstarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setStarred(false);
		
		taskEntryRepository.save(task);
	}
}
