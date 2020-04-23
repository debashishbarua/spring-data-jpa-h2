package com.cognizant.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	AddressRepository repository;

	public void save(Address address) {
		repository.save(address);
	}
}
