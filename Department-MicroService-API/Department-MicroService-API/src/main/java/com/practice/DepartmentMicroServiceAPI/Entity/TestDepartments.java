package com.practice.DepartmentMicroServiceAPI.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestDepartments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	private String departmentName;
	private int organizationId;
	private String organizationName;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public TestDepartments(int departmentId, String departmentName, int organizationId, String organizationName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}
	public TestDepartments() {
		super();
	}
	@Override
	public String toString() {
		return "TestDepartments [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", organizationId=" + organizationId + ", organizationName=" + organizationName + "]";
	}
}
