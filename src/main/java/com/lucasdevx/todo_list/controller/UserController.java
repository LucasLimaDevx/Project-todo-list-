package com.lucasdevx.todo_list.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdevx.todo_list.dto.UserDTO;
import com.lucasdevx.todo_list.model.User;
import com.lucasdevx.todo_list.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO insert(@RequestBody UserDTO userDTO) {
		
		User user = userService.parseToEntity(userDTO);
		
		return userService.parseToDTO(userService.insert(user));
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return userService.parseToDTO(userService.findById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> findAll(){
		
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = users.stream()
				.map(user -> userService.parseToDTO(user))
				.collect(Collectors.toList());
		
		return usersDTO;
	}
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO update(@RequestBody UserDTO userDTO) {
		User user = userService.parseToEntity(userDTO);
		
		return userService.parseToDTO(userService.update(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
