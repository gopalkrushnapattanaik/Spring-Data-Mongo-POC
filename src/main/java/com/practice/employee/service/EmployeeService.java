package com.practice.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee.pojo.Employee;
import com.practice.employee.repository.EmployeeRepository;

@RestController
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@GetMapping(value = "/employee/department/{id}")
	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable("id") String department){
		
		ResponseEntity<List<Employee>> response=null;
		
		response = new ResponseEntity<List<Employee>>(repository.findByDepartment(department), HttpStatus.OK);
		
		return response;
		
	}
	
}
