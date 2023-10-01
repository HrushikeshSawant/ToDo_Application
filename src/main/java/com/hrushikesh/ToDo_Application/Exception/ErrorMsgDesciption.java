package com.hrushikesh.ToDo_Application.Exception;

public class ErrorMsgDesciption {

	private String httpStatus;
	private String msgDescription;

	public ErrorMsgDesciption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMsgDesciption(String httpStatus, String msgDescription) {
		super();
		this.httpStatus = httpStatus;
		this.msgDescription = msgDescription;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMsgDescription() {
		return msgDescription;
	}

	public void setMsgDescription(String msgDescription) {
		this.msgDescription = msgDescription;
	}

	@Override
	public String toString() {
		return "ErrorMsgDesciption [httpStatus=" + httpStatus + ", msgDescription=" + msgDescription + "]";
	}

}
