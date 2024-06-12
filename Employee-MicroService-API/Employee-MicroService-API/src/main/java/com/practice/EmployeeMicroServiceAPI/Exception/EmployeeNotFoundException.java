package com.practice.EmployeeMicroServiceAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException
{
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	public EmployeeNotFoundException(String resourceName, String fieldName, String fieldValue) 
	{
		super(resourceName+" not found for "+fieldName+" : "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
