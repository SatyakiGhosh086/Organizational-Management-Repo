package com.practice.DepartmentMicroServiceAPI.Utility;

import java.util.ArrayList;
import java.util.List;

import com.practice.DepartmentMicroServiceAPI.Entity.TestDepartments;

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
