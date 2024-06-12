package com.practice.OrganizationMicroServiceAPI.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.OrganizationMicroServiceAPI.Utilities.DepartmentList;
import com.practice.OrganizationMicroServiceAPI.Utilities.EmployeeList;
import com.practice.OrganizationMicroServiceAPI.Utilities.TestDepartments;
import com.practice.OrganizationMicroServiceAPI.Utilities.TestEmployees;
import com.practice.OrganizationMicroServiceAPI.Utilities.TestOrganization;

@RestController
public class TestOrganizationController 
{
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/organization/{organizationId}/department/{departmentId}/employee/{employeeId}/get")
	public TestOrganization getEmployeeRecord(@PathVariable int organizationId, @PathVariable int departmentId, @PathVariable int employeeId) throws Exception
	{
		String empUrl = "http://Employee-MicroService-API/rest/v1/department/"+departmentId+"/employee/"+employeeId+"/get";
		TestEmployees emp = restTemplate.getForObject(empUrl, TestEmployees.class);
		
		String deptUrl = "http://Department-MicroService-API/rest/v1/caller/organization/"+organizationId+"/department/"+departmentId+"/get";
		TestDepartments dept = restTemplate.getForObject(deptUrl, TestDepartments.class);
		
		TestOrganization org = new TestOrganization();
		org.setEmployeeId(employeeId);
		org.setFirstName(emp.getFirstName());
		org.setLastName(emp.getLastName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		org.setDateOfJoining(formatter.parse(emp.getDateOfJoining()));
		org.setDepartmentId(departmentId);
		org.setDepartmentName(dept.getDepartmentName());
		org.setOrganizationId(organizationId);
		org.setOrganizationName(dept.getOrganizationName());
		
		return org;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/rest/v1/organization/{organizationId}/get/all")
	public List<TestOrganization> getOrganizationDate(@PathVariable int organizationId) throws Exception
	{
		String deptUrl = "http://Department-MicroService-API/rest/v1/caller/organization/"+organizationId+"/get/department/all";
		DepartmentList depts = restTemplate.getForObject(deptUrl, DepartmentList.class);
		
		List<TestOrganization> orgData = new ArrayList<>();
		
		for(TestDepartments dept : depts.getDepts())
		{
			String empUrl = "http://Employee-MicroService-API/rest/v1/department/"+dept.getDepartmentId()+"/employee/getAll";
			EmployeeList emps = restTemplate.getForObject(empUrl, EmployeeList.class);
			
			for(TestEmployees emp : emps.getEmps())
			{
				TestOrganization org = new TestOrganization();
				org.setEmployeeId(emp.getEmployeeId());
				org.setFirstName(emp.getFirstName());
				org.setLastName(emp.getLastName());
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				org.setDateOfJoining(formatter.parse(emp.getDateOfJoining()));
				org.setDepartmentId(dept.getDepartmentId());
				org.setDepartmentName(dept.getDepartmentName());
				org.setOrganizationId(organizationId);
				org.setOrganizationName(dept.getOrganizationName());
				
				orgData.add(org);
			}
			
		}
		return orgData;
	}
}
