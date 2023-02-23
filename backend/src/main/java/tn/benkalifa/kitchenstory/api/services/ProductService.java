package tn.benkalifa.kitchenstory.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.benkalifa.kitchenstory.api.model.Product;
import tn.benkalifa.kitchenstory.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}
	
	public Product save (Product product ) {
		return  productRepo.save(product);
		
	}
	
	public void delete (Integer id ) {
		 if (id == null) {
		      return;
		    }
		  productRepo.deleteById(id);
		
	}



}
