package tn.benkalifa.kitchenstory.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.benkalifa.kitchenstory.api.controller.api.PaymentApi;
import tn.benkalifa.kitchenstory.api.model.Payment;
import tn.benkalifa.kitchenstory.api.services.PaymentService;
@CrossOrigin(origins = "*")
@RestController
public class PaymentController implements PaymentApi  {
	@Autowired
	private  PaymentService service;

	@Override
	public Payment save(Payment payment) {
		
		return service.save(payment);
	}


	

	
	

}
