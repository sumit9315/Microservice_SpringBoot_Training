package com.office.employeeapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	
    private String address1 ;
    private String address2; 
    private String address3; 
    private String city; 
    private String state; 
    private String pincode; 
}
