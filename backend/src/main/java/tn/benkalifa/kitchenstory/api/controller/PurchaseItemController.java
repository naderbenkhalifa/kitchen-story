package tn.benkalifa.kitchenstory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


import tn.benkalifa.kitchenstory.api.controller.api.PurchaseItemApi;

import tn.benkalifa.kitchenstory.api.model.PurchaseItem;
import tn.benkalifa.kitchenstory.api.services.PurchaseItemService;
@CrossOrigin(origins = "*")
@RestController
public class PurchaseItemController implements PurchaseItemApi{
	
	@Autowired
	private PurchaseItemService purchaseItemService;
	@Override
	public List<PurchaseItem> findAll() {
		
		return purchaseItemService.findAll();
	}
	
	@Override
	public PurchaseItem save(PurchaseItem purchaseItem) {
		// TODO Auto-generated method stub
		return purchaseItemService.save(purchaseItem);
	}

}
