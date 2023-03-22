package tn.benkalifa.kitchenstory.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.benkalifa.kitchenstory.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	public Customer findByEmailAndPassword(String email,String password);
	public 	Optional<Customer> findByEmail(String email);
}
