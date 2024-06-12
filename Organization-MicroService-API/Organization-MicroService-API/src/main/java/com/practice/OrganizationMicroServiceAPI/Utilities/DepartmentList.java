package com.practice.OrganizationMicroServiceAPI.Utilities;

import java.util.ArrayList;
import java.util.List;


public class DepartmentList 
{
	private List<TestDepartments> depts = new ArrayList<>();

	public List<TestDepartments> getDepts() {
		return depts;
	}

	public void setDepts(List<TestDepartments> depts) {
		this.depts = depts;
	}

	public DepartmentList(List<TestDepartments> depts) {
		super();
		this.depts = depts;
	}

	public DepartmentList() {
		super();
	}
	
	
}
