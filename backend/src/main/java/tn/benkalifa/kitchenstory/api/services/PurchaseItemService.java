package tn.benkalifa.kitchenstory.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.benkalifa.kitchenstory.api.model.PurchaseItem;
import tn.benkalifa.kitchenstory.api.repository.PurchaseItemRepository;

@Service
public class PurchaseItemService {
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepo;

	public List<PurchaseItem> findAll() {
		return purchaseItemRepo.findAll();
	}
	
	public PurchaseItem save (PurchaseItem purchaseItem ) {
		return  purchaseItemRepo.save(purchaseItem);
		
	}

}
