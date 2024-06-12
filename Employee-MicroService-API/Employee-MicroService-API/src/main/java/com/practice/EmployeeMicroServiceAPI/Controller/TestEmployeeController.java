package com.practice.EmployeeMicroServiceAPI.Controller;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.practice.EmployeeMicroServiceAPI.Entity.TestEmployees;
import com.practice.EmployeeMicroServiceAPI.Exception.EmployeeNotFoundException;
import com.practice.EmployeeMicroServiceAPI.Exception.ErrorCodeDetails;
import com.practice.EmployeeMicroServiceAPI.Model.TestEmployeeModel;
import com.practice.EmployeeMicroServiceAPI.Service.TestEmployeeService;
import com.practice.EmployeeMicroServiceAPI.Utility.EmployeeList;

@RestController
public class TestEmployeeController 
{
	@Autowired
	private TestEmployeeService empService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/rest/v1/department/{departmentId}/employee/add")
	public ResponseEntity<TestEmployees> addEmployee(@PathVariable int departmentId, @RequestBody TestEmployeeModel model) throws ParseException 
	{
		return empService.addEmployee(departmentId, model);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/department/employee/getAll")
	public EmployeeList getAllEmployees()
	{
		return empService.getAllEmployees(); 
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/department/{departmentId}/employee/getAll")
	public EmployeeList getAllEmployeesByDepartmentId(@PathVariable int departmentId)
	{
		return empService.getAllEmployeesByDepartmentId(departmentId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/department/{departmentId}/employee/{employeeId}/get")
	public TestEmployees getEmployeeByDepartmentIdAndEmployeeID(@PathVariable int departmentId,@PathVariable int employeeId)
	{
		return empService.getEmployeeByDepartmentIdAndEmployeeID(departmentId, employeeId);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/rest/v1/department/{departmentId}/employee/{employeeId}/update")
	public ResponseEntity<TestEmployees> updateEmployee(@PathVariable int departmentId, @PathVariable int employeeId, @RequestBody TestEmployeeModel model) throws ParseException
	{
		return empService.updateEmployee(departmentId, employeeId, model);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/rest/v1/department/{departmentId}/employee/{employeeId}/delete")
	public ResponseEntity<String> deleteEmployee(int departmentId, int employeeId)
	{
		return empService.deleteEmployee(departmentId, employeeId);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorCodeDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest webRequest)
	{
		return new ResponseEntity<>(new ErrorCodeDetails(LocalDateTime.now(), ex.getMessage()
				,webRequest.getDescription(false),"Employee Not Found"), HttpStatus.NOT_FOUND);
	}
}
