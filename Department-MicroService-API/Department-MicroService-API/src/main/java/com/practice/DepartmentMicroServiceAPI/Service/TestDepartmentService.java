package com.practice.DepartmentMicroServiceAPI.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.DepartmentMicroServiceAPI.Entity.TestDepartments;
import com.practice.DepartmentMicroServiceAPI.Exception.DepartmentNotFoundException;
import com.practice.DepartmentMicroServiceAPI.Model.TestDepartmentModel;
import com.practice.DepartmentMicroServiceAPI.Repository.TestDepartmentRepository;
import com.practice.DepartmentMicroServiceAPI.Utility.DepartmentList;

@Service
public class TestDepartmentService 
{
	@Autowired
	private TestDepartmentRepository deptRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<TestDepartments> addDeparment(int organizationId, TestDepartmentModel model)
	{
		TestDepartments dept = new TestDepartments();
		dept.setDepartmentName(model.getDepartmentName());
		dept.setOrganizationId(organizationId);
		dept.setOrganizationName(model.getOrganizationName());
		
		deptRepo.save(dept);
		
		return new ResponseEntity<>(dept,HttpStatus.OK);
	}
	
	public DepartmentList getAllDepartments()
	{
		List<TestDepartments> depts = new ArrayList<>();
		deptRepo.findAll().forEach(depts::add);
		
		DepartmentList listOfDepts = new DepartmentList();
		listOfDepts.setDepts(depts);
		
		return listOfDepts;
		
	}
	
	public DepartmentList getAllDepartmentsByOrganizationId(int organizationId)
	{
		List<TestDepartments> depts = new ArrayList<>();
		deptRepo.findAllByOrganizationId(organizationId).forEach(depts::add);
		
		DepartmentList listOfDepts = new DepartmentList();
		listOfDepts.setDepts(depts);
		
		return listOfDepts;
		
	}
	
	public TestDepartments getDepartmentByOrganizationIdAndDepartmentId(int organizationId, int departmentId)
	{
		Optional<TestDepartments> checkDept = Optional.ofNullable(deptRepo.findByOrganizationIdAndDepartmentId(organizationId, departmentId));
		
		TestDepartments dept = checkDept.orElseThrow(() -> new DepartmentNotFoundException("Department","DepartmentId",departmentId+""));
		
		return checkDept.get();
	}
	
	public ResponseEntity<TestDepartments> updateDepartment(int organizationId, int departmentId, TestDepartmentModel model)
	{
		Optional<TestDepartments> checkDept = Optional.ofNullable(deptRepo.findByOrganizationIdAndDepartmentId(organizationId, departmentId));
		
		TestDepartments dept = checkDept.orElseThrow(() -> new DepartmentNotFoundException("Department","DepartmentId",departmentId+""));
		
		dept.setDepartmentName(model.getDepartmentName());
		dept.setOrganizationName(model.getOrganizationName());
		
		deptRepo.save(dept);
		
		return new ResponseEntity<>(dept,HttpStatus.OK);
		
	}
	
	public ResponseEntity<String> deleteDepartment(int organizationId, int departmentId)
	{
		Optional<TestDepartments> checkDept = Optional.ofNullable(deptRepo.findByOrganizationIdAndDepartmentId(organizationId, departmentId));
		
		TestDepartments dept = checkDept.orElseThrow(() -> new DepartmentNotFoundException("Department","DepartmentId",departmentId+""));
		
		deptRepo.deleteById(departmentId);
		
		return new ResponseEntity<>("A Departmnet record has been deleted : "+departmentId,HttpStatus.OK);
	}
	
	
}
