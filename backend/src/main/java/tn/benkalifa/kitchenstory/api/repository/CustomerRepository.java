package tn.benkalifa.kitchenstory.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.benkalifa.kitchenstory.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String>{
	public Customer findByEmailAndPassword(String email,String password);
}
