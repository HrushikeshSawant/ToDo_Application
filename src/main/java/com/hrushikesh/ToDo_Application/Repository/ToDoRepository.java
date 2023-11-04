package com.hrushikesh.ToDo_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrushikesh.ToDo_Application.Entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer>{

	
}
