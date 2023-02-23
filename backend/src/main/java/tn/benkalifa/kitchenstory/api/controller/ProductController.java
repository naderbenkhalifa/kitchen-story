package tn.benkalifa.kitchenstory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.benkalifa.kitchenstory.api.controller.api.ProductApi;
import tn.benkalifa.kitchenstory.api.model.Product;
import tn.benkalifa.kitchenstory.api.services.ProductService;
@CrossOrigin(origins = "*")
@RestController
public class ProductController implements ProductApi {
	@Autowired
	private ProductService productService;

	public List<Product> findAll() {
		
		return productService.findAll();
	}

	@Override
	public Product save(Product product) {
		
		return productService.save(product);
	}

	@Override
	public void delete(Integer id) {
		productService.delete(id);
		
	}

}
