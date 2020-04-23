package com.cognizant.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository repository;
	
	public void save(Library library){
		repository.save(library);
	}

}
