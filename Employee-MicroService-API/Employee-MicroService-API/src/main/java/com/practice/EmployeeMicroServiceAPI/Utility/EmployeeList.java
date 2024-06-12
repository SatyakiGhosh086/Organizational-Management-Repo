package com.practice.EmployeeMicroServiceAPI.Utility;

import java.util.ArrayList;
import java.util.List;

import com.practice.EmployeeMicroServiceAPI.Entity.TestEmployees;

public class EmployeeList 
{
	private List<TestEmployees> emps = new ArrayList<>();

	public List<TestEmployees> getEmps() {
		return emps;
	}

	public void setEmps(List<TestEmployees> emps) {
		this.emps = emps;
	}

	public EmployeeList(List<TestEmployees> emps) {
		super();
		this.emps = emps;
	}

	public EmployeeList() {
		super();
	}
	
	
	
}
