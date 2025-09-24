package com.office.employeeapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office.employeeapi.models.Employee;
import com.office.employeeapi.models.EmployeeResponse;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	Employee getEmployeeByid(int id);
//	EmployeeResponse getEmployeeByid(int id);

}
