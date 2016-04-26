package com.sample.todo.app.domain.task.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class UnstarTaskCommand {

	@TargetAggregateIdentifier
	private final String id;

	public UnstarTaskCommand(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}