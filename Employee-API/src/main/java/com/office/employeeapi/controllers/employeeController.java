package com.office.employeeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.employeeapi.models.Employee;
import com.office.employeeapi.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class employeeController {
	
	@Autowired
	EmployeeService serv;
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable int id)
	{
//		return serv.getEmployeeById(id);
		return ResponseEntity.ok(serv.getEmployeeById(id));
	}

}
