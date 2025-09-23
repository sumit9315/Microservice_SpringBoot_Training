package com.example.employeesapi.repos;

//import java.beans.BeanProperty;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employeesapi.models.Employee;

@Repository
public class EmployeesRepo {
	
	//use db configuration from application poperties file to connect to db
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public int addEmployee(Employee emp)
	{
		//1 query statement
		String query="INSERT INTO employees(name,city,age,designation)values(?,?,?,?)";
		//2 prepare statement
//		emp.getName(),emp.getCity(),emp.getAge(),emp.getDesignation()

//		3.pass query and prepare statement in update for jdbc to update in db and 
//		it will return  no. of rows affected which is integer so return type of function is int
		
		return jdbc.update(query,emp.getName(),emp.getCity(),emp.getAge(),emp.getDesignation());
	}
	
	public int updateEmployee(Employee emp)
	{
		//1 query statement
		String query="update employees set name=?,city=?,age=?,designation=? where id=?";
		//2 prepare statement
//		emp.getName(),emp.getCity(),emp.getAge(),emp.getDesignation()

//		3.pass query and prepare statement in update for jdbc to update in db
		return jdbc.update(query,emp.getName(),emp.getCity(),emp.getAge(),emp.getDesignation(),emp.getId());
	}

//	public int DeleteEmployee(emp)
	public int DeleteEmployee(int id)
	{
		//1 query statement
		String query="delete from employees where id=?";
		//2 prepare statement
//		emp.getName(),emp.getCity(),emp.getAge(),emp.getDesignation()

//		3.pass query and prepare statement in update for jdbc to update in db and it will return  no. of rows affected which is integer so return type of function is int
		return jdbc.update(query,id);
	}
	
	public List<Employee> getAllEmployees()
	{
		String query="select * from employees";
		return jdbc.query(query, new BeanPropertyRowMapper <>(Employee.class));
	}
	
	public Employee getEmployeeById(int id)
	{
		String query="select * from employees where id=?";
		return jdbc.queryForObject(query, new BeanPropertyRowMapper <>(Employee.class),id);
	}


}
