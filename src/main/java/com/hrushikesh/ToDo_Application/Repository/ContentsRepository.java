package com.hrushikesh.ToDo_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrushikesh.ToDo_Application.Entity.ContentsEntity;

public interface ContentsRepository extends JpaRepository<ContentsEntity, Integer>{

}
