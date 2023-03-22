package tn.benkalifa.kitchenstory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.benkalifa.kitchenstory.api.controller.api.CustomerApi;
import tn.benkalifa.kitchenstory.api.model.Customer;
import tn.benkalifa.kitchenstory.api.services.CustomerService;
@CrossOrigin(origins = "*")
@RestController
public class CustomerController implements CustomerApi {

	@Autowired
	private CustomerService customerService;
	@Override
	public List<Customer> findAll() {
		
		return customerService.findAll();
	}
	@Override
	public Customer save(Customer customer) {
		
		return customerService.save(customer);
	}
	@Override
	public Customer findByEmail (String email ) {
		return customerService.findByEmail(email);
	}
	@Override
	public Customer findByEmailAndPassword(String email, String password) {
		return customerService.getCustomerByEmailAndPassword(email, password);
	
	}
	@Override
	public Customer addUserLogin(Customer customer) throws Exception {
		 String email=customer.getEmail();
			String password=customer.getPassword();
			Customer customerobj=null;
			
			
			if(email!=null && password!=null)
			{
				customerobj=customerService.getCustomerByEmailAndPassword(email, password);
			}
			if(customerobj==null)
			{
				throw new Exception("Bad credentials ");
			}
				return customerobj;
			}
	@Override
	public Customer findById(int id) {
		
		return  customerService.findById(id) ;
	}
	@Override
	public Customer updatePassword(Customer customer,String email,String newPassword) {
		Customer x = customerService.findByEmail(email);
		 
		x.setPassword(newPassword);
		return customerService.save(x);
		
	
		
		
	}
	
	
	}
	
	
	
	


