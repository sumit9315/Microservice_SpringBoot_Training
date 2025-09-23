package com.example.employeesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeesapi.models.Employee;
import com.example.employeesapi.repos.EmployeesRepo;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
	
	@Autowired
	private EmployeesRepo repo;
	
	
//	@GetMapping
//	public List<Employee> getAll()
//	{
//		return repo.getAllEmployees();
//	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAll()
	{
		List<Employee> emps= repo.getAllEmployees();
		
		if(emps.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(emps);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id)
	{
		try {
			Employee emp =repo.getEmployeeById(id);
			if(emp.getId()!=0)
			{
				return ResponseEntity.ok(emp);
			}
			return ResponseEntity.notFound().build();
		}
		catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<String> AddEmployee(@RequestBody Employee emp)
	{
		int rowCount=repo.addEmployee(emp);
		if(rowCount>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Employee Detailed Saved Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
		}
		}
			
			
	

	@PutMapping("/{id}")
	public ResponseEntity<String> UpdateEmployee(@PathVariable int id,@RequestBody Employee emp)
	{
		emp.setId(id);
		int rowCount=repo.updateEmployee(emp);
		if(rowCount>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Employee detail updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee not found");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable int id)
	{
//		List<Employee> emps= repo.getAllEmployees();
		int rowCount=repo.DeleteEmployee(id);
		if(rowCount>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee not found");
		}
	}
}

