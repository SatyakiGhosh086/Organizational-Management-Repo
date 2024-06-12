package com.practice.EmployeeMicroServiceAPI.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.EmployeeMicroServiceAPI.Entity.TestEmployees;
import com.practice.EmployeeMicroServiceAPI.Exception.EmployeeNotFoundException;
import com.practice.EmployeeMicroServiceAPI.Model.TestEmployeeModel;
import com.practice.EmployeeMicroServiceAPI.Repository.TestEmployeeRepository;
import com.practice.EmployeeMicroServiceAPI.Utility.EmployeeList;

@Service
public class TestEmployeeService 
{
	@Autowired
	private TestEmployeeRepository empRepo;
	
	
	public ResponseEntity<TestEmployees> addEmployee(int departmentId, TestEmployeeModel model) throws ParseException
	{
		TestEmployees emp = new TestEmployees();
		emp.setDepartmentId(departmentId);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		emp.setDateOfJoining(format.parse(model.getDateOfJoining()));
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		empRepo.save(emp);
		
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	public EmployeeList getAllEmployees()
	{
		List<TestEmployees> emps = new ArrayList<>();
		empRepo.findAll().forEach(emps::add);
		
		EmployeeList empList = new EmployeeList();
		empList.setEmps(emps);
		
		return empList;
	}
	
	public EmployeeList getAllEmployeesByDepartmentId(int departmentId)
	{
		List<TestEmployees> emps = new ArrayList<>();
		empRepo.findAllByDepartmentId(departmentId).forEach(emps::add);
		
		EmployeeList empList = new EmployeeList();
		empList.setEmps(emps);
		
		return empList;
	}
	
	public TestEmployees getEmployeeByDepartmentIdAndEmployeeID(int departmentId,int employeeId)
	{
		Optional<TestEmployees> empCheck = Optional.ofNullable(empRepo.findByDepartmentIdAndEmployeeId(departmentId, employeeId));
		
		TestEmployees emp = empCheck.orElseThrow(() -> new EmployeeNotFoundException("Employee","EmployeeID",employeeId+""));
		
		return emp;
	}
	
	public ResponseEntity<TestEmployees> updateEmployee(int departmentId, int employeeId, TestEmployeeModel model) throws ParseException
	{
		Optional<TestEmployees> empCheck = Optional.ofNullable(empRepo.findByDepartmentIdAndEmployeeId(departmentId, employeeId));
		
		TestEmployees updateEmp = empCheck.orElseThrow(() -> new EmployeeNotFoundException("Employee","EmployeeID",employeeId+""));
		
		updateEmp.setFirstName(model.getFirstName());
		updateEmp.setLastName(model.getLastName());
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		updateEmp.setDateOfJoining(format.parse(model.getDateOfJoining()));
		
		empRepo.save(updateEmp);
		
		return new ResponseEntity<>(updateEmp,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteEmployee(int departmentId, int employeeId)
	{
		Optional<TestEmployees> empCheck = Optional.ofNullable(empRepo.findByDepartmentIdAndEmployeeId(departmentId, employeeId));
		
		TestEmployees emp = empCheck.orElseThrow(() -> new EmployeeNotFoundException("Employee","EmployeeID",employeeId+""));
		
		empRepo.deleteById(emp.getEmployeeId());
		
		return new ResponseEntity<>("Employee record has been deleted : "+emp.getEmployeeId(),HttpStatus.OK);
	}
	
}
