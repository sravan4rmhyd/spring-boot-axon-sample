package com.sample.todo.app.domain.task.commands;

import javax.validation.constraints.NotNull;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class ModifyTaskTitleCommand {

	@TargetAggregateIdentifier
	private final String id;

	@NotNull
	private final String title;

	public ModifyTaskTitleCommand(String id, String title) {
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

