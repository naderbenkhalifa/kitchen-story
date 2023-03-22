package tn.benkalifa.kitchenstory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.benkalifa.kitchenstory.api.controller.api.PurchaseApi;
import tn.benkalifa.kitchenstory.api.model.Purchase;
import tn.benkalifa.kitchenstory.api.services.PurchaseService;
@CrossOrigin(origins = "*")
@RestController
public class PurchaseController implements PurchaseApi{

	@Autowired
	private PurchaseService purchaseService;
	@Override
	public List<Purchase> findAll() {
		
		return purchaseService.findAll();
	}
	@Override
	public Purchase save(Purchase purchase) {
		
		return purchaseService.save(purchase);
	}
	
	 

}
