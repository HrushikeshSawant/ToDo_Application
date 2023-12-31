package com.hrushikesh.ToDo_Application.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class ToDoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "ToDo_content_Mapping", joinColumns = { @JoinColumn(name = "ToDo_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "content_Id") })
	private List<ContentsEntity> content;
	
	public ToDoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoEntity(int id, String title, String description, List<ContentsEntity> content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ContentsEntity> getcontent() {
		return content;
	}

	public void setcontent(List<ContentsEntity> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ToDoEntity [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ "]";
	}

}
