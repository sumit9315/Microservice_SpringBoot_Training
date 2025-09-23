package com.office.addressapi.services;

import java.util.List;

import com.office.addressapi.models.Address;

public interface AddressService {
	
	Address GetAddressByEmployeeId(int id);
//	public List<Address> GetAll();

}
