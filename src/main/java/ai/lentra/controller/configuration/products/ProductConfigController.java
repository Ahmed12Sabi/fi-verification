package ai.lentra.controller.configuration.products;



import ai.lentra.dto.masterconfig.ProductsDTO;
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
	@PostMapping("/product_config")
	public ResponseEntity<ResponseDTO> saveRole( @RequestBody ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.saveProduct(productsDTO);
	}

	@PutMapping("/product_config")
	public ResponseEntity<ResponseDTO> updateRole( @RequestBody ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.updateProduct(productsDTO);
	}

	@GetMapping("/master_product_config")
	public ResponseEntity<Object>getAllproducts() throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.getAllProducts();
	}

	@GetMapping("/products_config/{productId}")
	public ResponseEntity<Object> getRole(@PathVariable Long productId) throws ResourceNotFoundException, DuplicateResourceException {

		return productsService.getProduct(productId);
	}

}
