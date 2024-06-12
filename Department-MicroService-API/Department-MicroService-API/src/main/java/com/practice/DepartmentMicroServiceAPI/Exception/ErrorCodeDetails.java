package com.practice.DepartmentMicroServiceAPI.Exception;

import java.time.LocalDateTime;

public class ErrorCodeDetails 
{
	private LocalDateTime localDateTime;
	private String errorMessage;
	private String errorPath;
	private String errorCode;
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorPath() {
		return errorPath;
	}
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorCodeDetails(LocalDateTime localDateTime, String errorMessage, String errorPath, String errorCode) {
		super();
		this.localDateTime = localDateTime;
		this.errorMessage = errorMessage;
		this.errorPath = errorPath;
		this.errorCode = errorCode;
	}
	public ErrorCodeDetails() {
		super();
	}
	
	
	
	
}
