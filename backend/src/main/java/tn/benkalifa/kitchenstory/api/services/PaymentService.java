package tn.benkalifa.kitchenstory.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.benkalifa.kitchenstory.api.model.Payment;
import tn.benkalifa.kitchenstory.api.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repo;
	
	public Payment save(Payment payment) {
		return repo.save(payment);
		
	}

	
	

}
