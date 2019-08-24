package com.practice.employee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee.pojo.Employee;
import com.practice.employee.repository.EmployeeRepository;

@RestController
@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(value = "/employee/department/{department}")
	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable("department") String department) {

		ResponseEntity<List<Employee>> response = null;

		response = new ResponseEntity<List<Employee>>(repository.findByDepartment(department), HttpStatus.OK);

		logger.info("GET RESPONSE getEmployeesByDepartment for department " + department + " " + response.getBody());

		return response;

	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") String id) {

		ResponseEntity<Employee> response = null;

		response = new ResponseEntity<Employee>(((Optional<Employee>) repository.findById(id)).get(), HttpStatus.OK);

		logger.info("GET RESPONSE getEmployeesById for employeeID " + id + " " + response.getBody());

		return response;

	}

	@PostMapping(value = "/employee/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		ResponseEntity<Employee> resEmployee = new ResponseEntity<Employee>(repository.save(employee),
				HttpStatus.CREATED);
		logger.info("New Employee Created "  + resEmployee.getBody());

		
		return resEmployee;

	}
}
