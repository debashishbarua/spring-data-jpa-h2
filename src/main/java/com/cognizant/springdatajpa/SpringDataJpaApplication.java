package com.cognizant.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	@Autowired
	private EmployeeService service;

	@Autowired
	LibraryService libraryService;

	@Autowired
	AddressService addressService;

	@Autowired
	BookService bookService;

	@Autowired
	StockService stockService;

	@Autowired
	CategoryRepository categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address address = new Address();
		address.setLocation("Kolkata");

		addressService.save(address);

		Library library = new Library();
		library.setName("Kings");
		library.setAddress(address);

		libraryService.save(library);

		Book book = new Book();
		book.setTitle("C++");
		book.setLibrary(library);

		Book book1 = new Book();
		book1.setTitle("C");
		book1.setLibrary(library);

		bookService.save(book);
		bookService.save(book1);

		// Many to Many
		Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

		Set<Category> categories = new HashSet<Category>();
		categories.add(category1);
		categories.add(category2);

		stock.setCategories(categories);

		stockService.save(stock);

	}

}
