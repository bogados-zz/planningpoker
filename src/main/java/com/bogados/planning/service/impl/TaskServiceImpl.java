package com.bogados.planning.service.impl;

import com.bogados.planning.repository.TaskRepository;
import com.bogados.planning.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
}
