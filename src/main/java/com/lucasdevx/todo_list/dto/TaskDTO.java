package com.lucasdevx.todo_list.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TaskDTO(
		Long id, 
		String title, 
		String description,
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dueDate, 
		String status
		) {}
