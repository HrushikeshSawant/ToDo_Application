package com.hrushikesh.ToDo_Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item;
	private Boolean isDone;

	public ItemsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsEntity(int id, String item, Boolean isDone) {
		super();
		this.id = id;
		this.item = item;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "ItemsEntity [id=" + id + ", item=" + item + ", isDone=" + isDone + "]";
	}

}
