package com.practice.DepartmentMicroServiceAPI.Controller;

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

import com.practice.DepartmentMicroServiceAPI.Entity.TestDepartments;
import com.practice.DepartmentMicroServiceAPI.Exception.DepartmentNotFoundException;
import com.practice.DepartmentMicroServiceAPI.Exception.ErrorCodeDetails;
import com.practice.DepartmentMicroServiceAPI.Model.TestDepartmentModel;
import com.practice.DepartmentMicroServiceAPI.Service.TestDepartmentService;
import com.practice.DepartmentMicroServiceAPI.Utility.DepartmentList;

@RestController
public class TestDepartmentController 
{
	@Autowired
	private TestDepartmentService deptService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/rest/v1/organization/{organizationId}/department/add")
	public ResponseEntity<?> addDepartment(@PathVariable int organizationId, @RequestBody TestDepartmentModel model)
	{
		return deptService.addDeparment(organizationId, model);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/caller/organization/get/department/all")
	public DepartmentList getAllDepartments()
	{
		return deptService.getAllDepartments();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/caller/organization/{organizationId}/get/department/all")
	public DepartmentList getAllDepartmentsByOrganizationId(@PathVariable int organizationId)
	{
		return deptService.getAllDepartmentsByOrganizationId(organizationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/caller/organization/{organizationId}/department/{departmentId}/get")
	public TestDepartments getDepartmentByOrganizationIdAndDepartmentId(@PathVariable int organizationId,@PathVariable int departmentId)
	{
		return deptService.getDepartmentByOrganizationIdAndDepartmentId(organizationId, departmentId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/rest/v1/caller/organization/{organizationId}/department/{departmentId}/update")
	public ResponseEntity<TestDepartments> updateDepartment(@PathVariable int organizationId, @PathVariable int departmentId, @RequestBody TestDepartmentModel model)
	{
		return deptService.updateDepartment(organizationId, departmentId, model);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/rest/v1/caller/organization/{organizationId}/department/{departmentId}/delete")
	public ResponseEntity<String> deleteDepartment(@PathVariable int organizationId, @PathVariable int departmentId)
	{
		return deptService.deleteDepartment(organizationId, departmentId);
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorCodeDetails> handleDepartmentNotFoundException(DepartmentNotFoundException ex, WebRequest webRequest)
	{
		return new ResponseEntity<>(new ErrorCodeDetails(LocalDateTime.now(), ex.getMessage()
				,webRequest.getDescription(false),"Department Not Found"), HttpStatus.NOT_FOUND);
	} 
}
