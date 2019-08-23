package com.practice.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.employee.pojo.Employee;
import com.practice.employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeService implements CommandLineRunner{
	
	
	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		repository.save(new Employee("100","Gopal","Pattanaik","Retail","50L"));
		repository.save(new Employee("101","Anand","Patnam","Retail","30L"));
		repository.save(new Employee("102","Rahul","Bajaj","Bank","30L"));
		
		System.out.println("Employees found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : repository.findAll()) {
			System.out.println(employee);
		}
		
		
		System.out.println("Employees found with Department: Retail");
		System.out.println("-------------------------------");
		List<Employee> employees= repository.findByDepartment("Retail");
		
		employees.stream().forEach(employee->System.out.println(employee));
	}

}
