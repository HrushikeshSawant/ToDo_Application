package com.hrushikesh.ToDo_Application.Entity;

import java.util.List;

public class ToDoEntityWrapper {

	private String title;
	private String description;

	private List<ItemsEntity> content;

	public ToDoEntityWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoEntityWrapper(String title, String description, List<ItemsEntity> content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
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

	public List<ItemsEntity> getContent() {
		return content;
	}

	public void setContent(List<ItemsEntity> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ToDoEntityWrapper [title=" + title + ", description=" + description + ", content=" + content + "]";
	}

}
