package com.office.addressapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.addressapi.models.Address;
import com.office.addressapi.repos.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo repo;
	
	@Override
	public Address GetAddressByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return repo.getByEmpid(id);
	}
//	@Override
//	public List<Address> GetAll() {
//		// TODO Auto-generated method stub
//		return repo.GetAll();
//	}

}
