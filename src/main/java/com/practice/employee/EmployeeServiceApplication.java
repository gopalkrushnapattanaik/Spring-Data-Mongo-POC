package com.practice.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.employee.pojo.Employee;
import com.practice.employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();

		repository.save(new Employee("100", "Gopal", "Pattanaik", "Retail", "50L"));
		repository.save(new Employee("101", "Anand", "Patnam", "Retail", "30L"));
		repository.save(new Employee("102", "Rahul", "Bajaj", "Bank", "30L"));

		logger.info("Employees found with findAll():");
		logger.info("-------------------------------");

		repository.findAll().stream().forEach(employee -> logger.info(employee.toString()));
		logger.info("-------------------------------");
		logger.info("Employees found with Department: Retail");
		logger.info("-------------------------------");
		List<Employee> employees = repository.findByDepartment("Retail");
		
		employees.stream().forEach(employee -> logger.info(employee.toString()));
		logger.info("-------------------------------");
	}

}
