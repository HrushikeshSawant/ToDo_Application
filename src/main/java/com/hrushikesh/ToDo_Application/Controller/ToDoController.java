package com.hrushikesh.ToDo_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrushikesh.ToDo_Application.Entity.ContentsEntity;
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
	
	@GetMapping("view")
	public ResponseEntity<List<ToDoEntity>> viewTodo()
	{
		return toDoService.viewTodo();
	}
	
	@GetMapping("view/{id}")
	public ResponseEntity<ToDoEntity> viewTodo(@PathVariable int id)
	{
		return toDoService.viewTodo(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateTodo(@PathVariable int id, @RequestBody ToDoEntity toDoEntity)
	{
		return toDoService.updateTodo(id, toDoEntity);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable int id)
	{
		return toDoService.updateTodo(id);
	}
	
	@PutMapping("add-todo-content/{id}")
	public ResponseEntity<String> updateToDoEntiry(@PathVariable int id, @RequestBody ContentsEntity contentsEntity)
	{
		return toDoService.updateToDoEntiry(id, contentsEntity);
	}
	
}
