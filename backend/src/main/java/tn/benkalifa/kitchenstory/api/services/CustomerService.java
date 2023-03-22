package tn.benkalifa.kitchenstory.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.benkalifa.kitchenstory.api.model.Customer;
import tn.benkalifa.kitchenstory.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	public List<Customer> findAll() {
		return customerRepo.findAll();
	}
	public Customer save (Customer customer ) {
		return  customerRepo.save(customer);
		
	}
	public Customer findByEmail (String email ) {
		Optional<Customer> customer= customerRepo.findByEmail(email);
		if(customer.isPresent()) return customer.get();
		return null;
		
	}
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		return customerRepo.findByEmailAndPassword(email, password);
	}
	public Customer findById (int  id) {
		Optional<Customer> customer= customerRepo.findById(id);
		if(customer.isPresent()) return customer.get();
		return null;
		
	}
	

}
