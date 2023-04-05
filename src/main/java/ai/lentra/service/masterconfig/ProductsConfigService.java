package ai.lentra.service.masterconfig;

import ai.lentra.dto.masterconfig.ProductsDTO;


import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ProductsConfigService {
    public ResponseEntity<ResponseDTO> saveProduct(ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<ResponseDTO> updateProduct(ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object> getAllProducts() throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object> getProduct(Long productId) throws ResourceNotFoundException, DuplicateResourceException;


}
