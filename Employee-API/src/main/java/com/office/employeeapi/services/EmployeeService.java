package com.office.employeeapi.services;

import com.office.employeeapi.models.Employee;
import com.office.employeeapi.models.EmployeeResponse;

public interface EmployeeService {
	
	Employee getEmployeeById(int id);
//	EmployeeResponse getEmployeeById(int id);

}
