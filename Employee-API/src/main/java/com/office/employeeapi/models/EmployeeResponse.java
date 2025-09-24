package com.office.employeeapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	private int id; 
    private String name;
    private int age;
    private String email ;
    private AddressResponse address;
}
