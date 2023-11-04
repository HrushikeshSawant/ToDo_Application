package com.hrushikesh.ToDo_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hrushikesh.ToDo_Application.Entity.ContentsEntity;

public interface ContentsRepository extends JpaRepository<ContentsEntity, Integer>{

	@Modifying
	@Transactional
	@Query(value="DELETE FROM to_do_content_mapping WHERE content_id = :id", nativeQuery = true)
	void deleteTodoContentMapping(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM ContentsEntity WHERE id = :id")
	void deleteById(@Param("id") int id);
	
}
