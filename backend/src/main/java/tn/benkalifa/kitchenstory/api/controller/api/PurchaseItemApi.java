package tn.benkalifa.kitchenstory.api.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.benkalifa.kitchenstory.api.model.PurchaseItem;
import tn.benkalifa.kitchenstory.api.util.Constants;

@Api("purchasesItems")
public interface PurchaseItemApi {
	
	@GetMapping(value = Constants.APP_ROOT + "/purchasesItems/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Renvoi la liste des elements d'achats", notes = "Cette methode permet de chercher et renvoyer la liste des elements d'achats qui existent "
	      + "dans la BDD", responseContainer = "List<PurchaseItem>")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "La liste des elements d'achats / Une liste vide")
	  })
	  List<PurchaseItem> findAll();
	
	@PostMapping(value = Constants.APP_ROOT + "/purchasesItems/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Enregistrer un achat", notes = "Cette methode permet d'enregistrer ou modifier un elemnt d'achat", response = PurchaseItem.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'objet element d'achat cree / modifie"),
	      @ApiResponse(code = 400, message = "L'objet element d'achat n'est pas valide")
	  })
	  PurchaseItem save(@RequestBody PurchaseItem purchase);

}
