package com.office.employeeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.employeeapi.models.Employee;
import com.office.employeeapi.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repo.getEmployeeByid(id);
	}

}
