package com.lucasdevx.todo_list.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TASK")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 50)
	private String title;
	
	@Column(name = "description", nullable = false, length = 50)
	private String description;
	
	@Column(name = "dueDate", nullable = false, length = 50)
	private LocalDateTime dueDate;
	
	@Column(name = "status", nullable = false, length = 12)
	private String status;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "category_id")
	@ManyToOne
	private Category category;
	
	
}
