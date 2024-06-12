package com.practice.EmployeeMicroServiceAPI.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.EmployeeMicroServiceAPI.Entity.TestEmployees;

public interface TestEmployeeRepository extends CrudRepository<TestEmployees, Integer>
{
	public List<TestEmployees> findAllByDepartmentId(int departmentId);
	public TestEmployees findByDepartmentIdAndEmployeeId(int departmentId, int employeeId);
	public TestEmployees findByEmployeeId(int employeeId);
}
