package com.cognizant.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	
	@Autowired
	StockRepository repository;
	
	
	public void save(Stock stock){
		repository.save(stock);
	}

}
