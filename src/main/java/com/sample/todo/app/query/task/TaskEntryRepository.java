package com.sample.todo.app.query.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskEntryRepository extends ElasticsearchRepository<TaskEntry, String> {
	Page<TaskEntry> findByUsernameAndCompleted(String username, boolean completed, Pageable pageable);
}
