package com.hrushikesh.ToDo_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrushikesh.ToDo_Application.Entity.ToDoEntity;
import com.hrushikesh.ToDo_Application.Service.ToDoService;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;

	@PostMapping("add")
	public ResponseEntity<String> addTodo(@RequestBody ToDoEntity toDoEntity)
	{
		return toDoService.addTodo(toDoEntity);
	}
	
}
