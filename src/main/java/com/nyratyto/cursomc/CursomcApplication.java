package com.nyratyto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nyratyto.cursomc.domain.Address;
import com.nyratyto.cursomc.domain.Category;
import com.nyratyto.cursomc.domain.City;
import com.nyratyto.cursomc.domain.Customer;
import com.nyratyto.cursomc.domain.Product;
import com.nyratyto.cursomc.domain.State;
import com.nyratyto.cursomc.domain.enums.CustomerType;
import com.nyratyto.cursomc.repositories.AddressRepository;
import com.nyratyto.cursomc.repositories.CategoryRepository;
import com.nyratyto.cursomc.repositories.CityRepository;
import com.nyratyto.cursomc.repositories.CustomerRepository;
import com.nyratyto.cursomc.repositories.ProductRepository;
import com.nyratyto.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product prod1 = new Product(null, "Computador", 2000.00);
		Product prod2 = new Product(null, "Impressora", 800.00);
		Product prod3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod1));
		
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		//
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City ct1 = new City(null, "Uberlândia", st1);
		City ct2 = new City(null, "São Paulo", st2);
		City ct3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(ct1));
		st2.getCities().addAll(Arrays.asList(ct2, ct3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(ct1, ct2, ct3));
		
		//
		
		Customer cust1 = new Customer(null, "Juana Paiva", "juanapaiva2019@gmail.com", "123456789", CustomerType.NATURALPERSON);
		cust1.getPhones().addAll(Arrays.asList("5500123456789", "5500987654321"));
		
		Address ad1 = new Address(null, "Rua Java", "11", "Casa", "Oracle", "00000000", cust1, ct2);
		Address ad2 = new Address(null, "Rua Spring", "4", "Casa", "Boot", "11111111", cust1, ct3);
		
		cust1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		
		customerRepository.saveAll(Arrays.asList(cust1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
	}

}

