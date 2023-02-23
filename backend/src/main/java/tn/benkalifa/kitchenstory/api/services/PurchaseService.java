package tn.benkalifa.kitchenstory.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.benkalifa.kitchenstory.api.model.Purchase;
import tn.benkalifa.kitchenstory.api.repository.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepo;

	public List<Purchase> findAll() {
		return purchaseRepo.findAll();
	}
	public Purchase save (Purchase purchase ) {
		return  purchaseRepo.save(purchase);
		
	}
	

}
