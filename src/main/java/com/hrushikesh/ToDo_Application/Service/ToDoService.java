package com.hrushikesh.ToDo_Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrushikesh.ToDo_Application.Entity.ToDoEntity;
import com.hrushikesh.ToDo_Application.Repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository toDoRepository;
	
	public ResponseEntity<String> addTodo(ToDoEntity toDoEntity)
	{
		toDoRepository.save(toDoEntity);
		return new ResponseEntity<>("ToDo Added!!", HttpStatus.CREATED) ;
	}

}
