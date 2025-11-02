package com.lucasdevx.todo_list.dto;

import java.time.LocalDateTime;

public record TaskDTO(
		Long id, 
		String title, 
		String description,
		LocalDateTime dueDate, 
		String status
		) {}
