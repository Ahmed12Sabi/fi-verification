package ai.lentra.controller.configuration.products;



import ai.lentra.dto.masterConfig.ProductsDTO;
import ai.lentra.service.masterconfig.ProductsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;

@Validated
@RestController
@RequestMapping(value = "/products")
public class ProductConfigController {
	@Autowired
	ProductsConfigService productsService;

	@PostMapping("/product-config")
	public ResponseEntity<ResponseDTO> saveRole( @RequestBody ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException {
		System.out.printf("from controller");
		return productsService.saveProduct(productsDTO);
	}

	@PutMapping("/product-config")
	public ResponseEntity<ResponseDTO> updateRole( @RequestBody ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.updateProduct(productsDTO);
	}

	@GetMapping("/products")
	public ResponseEntity<Object>getAllproducts() throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.getAllProducts();
	}

	@GetMapping("/product-config/{productId}")
	public ResponseEntity<Object> getRole(@PathVariable Long productId) throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.getProduct(productId);
	}

}
