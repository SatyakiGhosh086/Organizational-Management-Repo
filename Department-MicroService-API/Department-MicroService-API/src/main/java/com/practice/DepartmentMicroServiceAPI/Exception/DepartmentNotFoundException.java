package com.practice.DepartmentMicroServiceAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException 
{
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	public DepartmentNotFoundException(String resourceName, String fieldName, String fieldValue) 
	{
		super(resourceName+" not found for "+fieldName+" : "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	
}
