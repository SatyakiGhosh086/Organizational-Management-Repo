package com.practice.OrganizationMicroServiceAPI.Utilities;

public class TestEmployees 
{
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateOfJoining;
	private int departmentId;
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
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public TestEmployees(int employeeId, String firstName, String lastName, String dateOfJoining, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.departmentId = departmentId;
	}
	public TestEmployees() {
		super();
	}
	@Override
	public String toString() {
		return "TestEmployees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfJoining=" + dateOfJoining + ", departmentId=" + departmentId + "]";
	}
}
