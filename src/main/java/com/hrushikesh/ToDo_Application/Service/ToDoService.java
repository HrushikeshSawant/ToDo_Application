package com.hrushikesh.ToDo_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrushikesh.ToDo_Application.Entity.ContentsEntity;
import com.hrushikesh.ToDo_Application.Entity.ToDoEntity;
import com.hrushikesh.ToDo_Application.Exception.ResourceNotFoundException;
import com.hrushikesh.ToDo_Application.Repository.ContentsRepository;
import com.hrushikesh.ToDo_Application.Repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	ToDoRepository toDoRepository;
	
	@Autowired
	ContentsRepository contentsRepository;

	public ResponseEntity<String> addTodo(ToDoEntity toDoEntity) 
	{
		toDoRepository.save(toDoEntity);
		return new ResponseEntity<>("ToDo Added!!", HttpStatus.CREATED);
	}

	public ResponseEntity<List<ToDoEntity>> viewTodo() 
	{
		return new ResponseEntity<>(toDoRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<ToDoEntity> viewTodo(int id) 
	{
		ToDoEntity toDoEntityFromDB =toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", Integer.toString(id)));
		return new ResponseEntity<>(toDoEntityFromDB, HttpStatus.OK);
	}

	public ResponseEntity<String> updateTodo(int id, ToDoEntity toDoEntity)
	{
		ToDoEntity exitingToDo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", Integer.toString(id)));
		
		if(toDoEntity.getTitle() != null)
			exitingToDo.setTitle(toDoEntity.getTitle());
		
		if(toDoEntity.getDescription() != null)
			exitingToDo.setDescription(toDoEntity.getDescription());
		
		List<ContentsEntity> exstingItems = exitingToDo.getcontent();
		List<ContentsEntity> newItems = toDoEntity.getcontent();
		
		newItems.forEach(e -> {
			
			exstingItems.forEach(e1 -> {
				
				if(e.getId() == e1.getId())
				{
					e1.setItem(e.getItem());
					e1.setIsDone(e.getIsDone());
				}
			});
		});
		
		System.out.println(exstingItems.toString());
		toDoRepository.save(exitingToDo);
		return new ResponseEntity<String>("ToDo updated!!", HttpStatus.OK);
	}
	
	public ResponseEntity<String> addTodoContent(int id, ContentsEntity contentsEntity) {

		ToDoEntity existingToDo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", Integer.toString(id)));
		List<ContentsEntity> existingTodoContents = existingToDo.getcontent();
		
		existingTodoContents.add(contentsEntity);
		existingToDo.setcontent(existingTodoContents);
		
		toDoRepository.save(existingToDo);
		return new ResponseEntity<String>("New Content Added!!", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateTodoContent(int id, ContentsEntity contentsEntity) {
		
		ToDoEntity existingToDo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", Integer.toString(id)));
		List<ContentsEntity> existingTodoContents = existingToDo.getcontent();
		
		for(int i = 0 ; i <= existingTodoContents.size() ; i++)
		{
			ContentsEntity ce = existingTodoContents.get(i);
			
			if(ce.getId() == contentsEntity.getId())
			{
				if(contentsEntity.getItem() != null)
					ce.setItem(contentsEntity.getItem());
				
				ce.setIsDone(contentsEntity.getIsDone());
				break;
			}
		}
		
		existingToDo.setcontent(existingTodoContents);
		toDoRepository.save(existingToDo);
		
		return new ResponseEntity<String>("ToDo Content Updated!!", HttpStatus.OK);
	}

}
