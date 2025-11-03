package com.lucasdevx.todo_list.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasdevx.todo_list.model.Task;

public record CategoryDTO(
		Long id, 
		String name, 
		String color,
		@JsonIgnore Set<Task> tasks) {}
