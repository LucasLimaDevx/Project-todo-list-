package com.lucasdevx.todo_list.dto;

import java.util.Set;

import com.lucasdevx.todo_list.model.Task;

public record UserDTO(
		Long id, 
		String name,
		String email,
		Set<Task> tasks) {}
