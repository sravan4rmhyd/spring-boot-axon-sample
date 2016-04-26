package com.sample.todo.app.notify.task;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.sample.todo.app.domain.task.events.TaskCompletedEvent;
import com.sample.todo.app.domain.task.events.TaskCreatedEvent;
import com.sample.todo.app.domain.task.events.TaskEvent;
import com.sample.todo.app.domain.task.events.TaskStarredEvent;
import com.sample.todo.app.domain.task.events.TaskTitleModifiedEvent;
import com.sample.todo.app.domain.task.events.TaskUnstarredEvent;
import com.sample.todo.app.query.task.TaskEntry;
import com.sample.todo.app.query.task.TaskEntryRepository;

@Component
public class TaskEventNotifyingEventHandler {
	
	private final SimpMessageSendingOperations messagingTemplate;
	
	private final TaskEntryRepository taskEntryRepository;
	
	@Autowired
	public TaskEventNotifyingEventHandler(SimpMessageSendingOperations messagingTemplate, TaskEntryRepository taskEntryRepository) {
		this.messagingTemplate = messagingTemplate;
		this.taskEntryRepository = taskEntryRepository;
	}
	
	@EventHandler
	void on(TaskCreatedEvent event) {
		TaskEntry task = new TaskEntry(event.getId(), event.getUsername(), event.getTitle(), false, false);
		taskEntryRepository.save(task);
		publish(event.getUsername(), event);
	}

	@EventHandler
	void on(TaskCompletedEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		publish(task.getUsername(), event);
	}
	
	@EventHandler
	void on(TaskTitleModifiedEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		publish(task.getUsername(), event);
	}
	
	@EventHandler
	void on (TaskStarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		publish(task.getUsername(), event);
	}
	
	@EventHandler
	void on (TaskUnstarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		publish(task.getUsername(), event);
	}
	
	private void publish(String username, TaskEvent event) {
		String type = event.getClass().getSimpleName();
		this.messagingTemplate.convertAndSendToUser(username, "/queue/task-updates", new TaskEventNotification(type, event));
	}
}
