package com.office.employeeapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office.employeeapi.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	Employee getEmployeeByid(int id);

}
