package com.hrushikesh.ToDo_Application.Exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1893450042950212324L;
	private String resoursename;
	private String fieldName;
	private String fieldValue;

	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String resoursename, String fieldName, String fieldValue) {
		super(resoursename + " not found for " + fieldName + ": " + fieldValue);
		this.resoursename = resoursename;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResoursename() {
		return resoursename;
	}

	public void setResoursename(String resoursename) {
		this.resoursename = resoursename;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

}
