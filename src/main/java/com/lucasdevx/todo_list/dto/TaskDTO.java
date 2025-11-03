package com.lucasdevx.todo_list.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.lucasdevx.todo_list.model.Category;
import com.lucasdevx.todo_list.model.User;

public record TaskDTO(
		Long id, 
		String title, 
		String description,
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dueDate, 
		String status,
		@JsonProperty(access = Access.WRITE_ONLY) User user,
		Category category
		) {}
