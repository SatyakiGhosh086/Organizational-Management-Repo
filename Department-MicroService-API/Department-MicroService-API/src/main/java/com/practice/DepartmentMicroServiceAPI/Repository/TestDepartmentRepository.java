package com.practice.DepartmentMicroServiceAPI.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.DepartmentMicroServiceAPI.Entity.TestDepartments;

public interface TestDepartmentRepository extends CrudRepository<TestDepartments, Integer>
{
	public TestDepartments findByDepartmentId(int departmentId);
	public List<TestDepartments> findAllByOrganizationId(int organizationId);
	public TestDepartments findByOrganizationIdAndDepartmentId(int organizationId,int departmentId);
}
