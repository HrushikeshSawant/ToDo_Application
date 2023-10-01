package com.hrushikesh.ToDo_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrushikesh.ToDo_Application.Entity.ToDoEntity;
import com.hrushikesh.ToDo_Application.Entity.ToDoEntityWrapper;
import com.hrushikesh.ToDo_Application.Exception.ResourceNotFoundException;
import com.hrushikesh.ToDo_Application.Repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	ToDoRepository toDoRepository;

	public ResponseEntity<String> addTodo(ToDoEntity toDoEntity) 
	{
		toDoRepository.save(toDoEntity);
		return new ResponseEntity<>("ToDo Added!!", HttpStatus.CREATED);
	}

	public ResponseEntity<List<ToDoEntity>> viewTodo() 
	{
		return new ResponseEntity<>(toDoRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<ToDoEntityWrapper> viewTodo(int id) 
	{
		ToDoEntity toDoEntityFromDB =toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", Integer.toString(id)));
		ToDoEntityWrapper toDoEntityWrapperDB = new ToDoEntityWrapper(toDoEntityFromDB.getTitle(), toDoEntityFromDB.getDescription(), toDoEntityFromDB.getcontent());
		return new ResponseEntity<>(toDoEntityWrapperDB, HttpStatus.OK);
	}

}
