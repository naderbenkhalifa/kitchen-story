package tn.benkalifa.kitchenstory.api.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.benkalifa.kitchenstory.api.model.Customer;
import tn.benkalifa.kitchenstory.api.util.Constants;

@Api("customers")
public interface CustomerApi {
	@GetMapping(value = Constants.APP_ROOT + "/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Renvoi la liste des customers", notes = "Cette methode permet de chercher et renvoyer la liste des clients qui existent "
	      + "dans la BDD", responseContainer = "List<Customer>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "La liste des clients / Une liste vide")
	  })
	  List<Customer> findAll();
	
	
	@PostMapping(value = Constants.APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Enregistrer un customer", notes = "Cette methode permet d'enregistrer ou modifier un customer", response =Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet customer cree / modifie"),
	      @ApiResponse(code = 400, message = "L'objet customer n'est pas valide")
	  })
	  Customer save(@RequestBody Customer customer);
	@GetMapping(value = Constants.APP_ROOT + "/customers/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Rechercher un customer par ID", notes = "Cette methode permet de chercher un customers par son Id", response = Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "Le customer a ete trouve dans la BDD"),
	      @ApiResponse(code = 404, message = "Aucun customer n'existe dans la BDD avec l'Id fourni")
	  })
	  
	public Customer findById (@PathVariable("id") int id ) ;
	
	
	@GetMapping(value = Constants.APP_ROOT + "/customers/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Rechercher un customer par Email", notes = "Cette methode permet de chercher un customers par son email", response = Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "Le customer a ete trouve dans la BDD"),
	      @ApiResponse(code = 404, message = "Aucun customer n'existe dans la BDD avec l'email fourni")
	  })
	  
	public Customer findByEmail (@PathVariable("email") String email ) ;
	
	
	 @GetMapping(value = Constants.APP_ROOT + "/customers/get/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Rechercher un client par email et password", notes = "Cette methode permet de chercher un client par son email et password", response = Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "Le client a ete trouve dans la BDD"),
	      @ApiResponse(code = 404, message = "Aucun client n'existe dans la BDD avec l'ID fourni")
	  })
	  Customer findByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password);
	 
	 
	 @PostMapping(value =Constants.APP_ROOT + "/customers/login/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Enregistrer clientlogin", notes = "Cette methode permet d'enregistrer un client login", response = Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet clientlogin crée"),
	      @ApiResponse(code = 400, message = "L'objet clientlogin n'est pas valide")
	  })
	 Customer addUserLogin (@RequestBody Customer customer) throws Exception ;

	 
	 @PostMapping(value = Constants.APP_ROOT + "/customers/updatePassword/{email}/{newPassword}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "modifier password d'un customer", notes = "Cette methode permet de   modifier password d'un customer", response =Customer.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet customer cree / modifie"),
	      @ApiResponse(code = 400, message = "L'objet customer n'est pas valide")
	  })
	  Customer updatePassword(@RequestBody Customer customer,@PathVariable String email,@PathVariable String newPassword);
	
}
