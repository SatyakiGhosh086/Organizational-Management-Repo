package com.practice.DepartmentMicroServiceAPI.Model;

public class TestDepartmentModel 
{
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
	public TestDepartmentModel(int departmentId, String departmentName, int organizationId, String organizationName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}
	public TestDepartmentModel() {
		super();
	}
	@Override
	public String toString() {
		return "TestDepartmentModel [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", organizationId=" + organizationId + ", organizationName=" + organizationName + "]";
	}

}
