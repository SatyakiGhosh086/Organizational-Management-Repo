package com.practice.OrganizationMicroServiceAPI.Utilities;

import java.util.Date;

public class TestOrganization 
{
	private int employeeId;
	private String firstName;
	private String lastName;
	private Date dateOfJoining;
	private int departmentId;
	private String departmentName;
	private int organizationId;
	private String organizationName;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
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
	public TestOrganization(int employeeId, String firstName, String lastName, Date dateOfJoining, int departmentId,
			String departmentName, int organizationId, String organizationName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}
	public TestOrganization() {
		super();
	}
	@Override
	public String toString() {
		return "TestOrganization [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfJoining=" + dateOfJoining + ", departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", organizationId=" + organizationId + ", organizationName=" + organizationName
				+ "]";
	}
	
	
}
