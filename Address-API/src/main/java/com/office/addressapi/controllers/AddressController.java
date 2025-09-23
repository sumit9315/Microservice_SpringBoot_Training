package com.office.addressapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.addressapi.models.Address;
import com.office.addressapi.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService serv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> GetAddressByEmployeeId(@PathVariable int id)
	{
//		return serv.GetAddressByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(serv.GetAddressByEmployeeId(id));
	}
//	@GetMapping()
//	public ResponseEntity<List<Address>> GetAll()
//	{
////		return serv.GetAddressByEmployeeId(id);
//		return ResponseEntity.status(HttpStatus.OK).body(serv.GetAll());
//	}
}
