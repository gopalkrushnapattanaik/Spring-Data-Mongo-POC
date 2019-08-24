package com.practice.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.employee.pojo.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public Optional<Employee> findById(String employeeId);

	public List<Employee> findByDepartment(String department);

	public Employee save(Employee employee);

	public List<Employee> findAll();

}
