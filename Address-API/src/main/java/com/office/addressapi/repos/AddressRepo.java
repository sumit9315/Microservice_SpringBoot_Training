package com.office.addressapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office.addressapi.models.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	public Address getByEmpid(int empid);
//	public List<Address> GetAll();
}
