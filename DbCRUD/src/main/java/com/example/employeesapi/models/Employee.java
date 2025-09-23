package com.example.employeesapi.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private int id;
	private String name;
	private String city;
	private int age;
	private String designation;

}
