package tn.benkalifa.kitchenstory.api.controller.api;




import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.benkalifa.kitchenstory.api.model.Product;
import tn.benkalifa.kitchenstory.api.util.Constants;

@Api("products")
public interface ProductApi {
	@GetMapping(value = Constants.APP_ROOT + "/products/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Renvoi la liste des produits", notes = "Cette methode permet de chercher et renvoyer la liste des produits qui existent "
	      + "dans la BDD", responseContainer = "List<Product>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "La liste des produits / Une liste vide")
	  })
	  List<Product> findAll();
	
	@PostMapping(value = Constants.APP_ROOT + "/products/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Enregistrer un produit", notes = "Cette methode permet d'enregistrer ou modifier un produir", response = Product.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet produit cree / modifie"),
	      @ApiResponse(code = 400, message = "L'objet produit n'est pas valide")
	  })
	  Product save(@RequestBody Product product);
	
	 @DeleteMapping(value = Constants.APP_ROOT + "/products/delete/{idProduct}")
	  @ApiOperation(value = "Supprimer un produit", notes = "Cette methode permet de supprimer un produit par ID")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "le produit a ete supprime")
	  })
	  void delete(@PathVariable("idProduct") Integer id);
}
