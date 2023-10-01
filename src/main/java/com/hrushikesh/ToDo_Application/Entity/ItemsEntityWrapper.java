package com.hrushikesh.ToDo_Application.Entity;

public class ItemsEntityWrapper {

	private String item;
	private Boolean isDone;

	public ItemsEntityWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsEntityWrapper(String item, Boolean isDone) {
		super();
		this.item = item;
		this.isDone = isDone;
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
		return "ItemsEntityWrapper [item=" + item + ", isDone=" + isDone + "]";
	}

}
