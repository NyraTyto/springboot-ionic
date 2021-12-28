package com.nyratyto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyratyto.cursomc.domain.Customer;
import com.nyratyto.cursomc.repositories.CustomerRepository;
import com.nyratyto.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer find(Integer id) {
		Optional<Customer> category = repo.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
	}
}
