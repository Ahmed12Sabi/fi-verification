package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.dto.masterconfig.ProductsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.ProductConfigEntity;
import ai.lentra.repository.masterconfig.ProductConfigRepository;
import ai.lentra.service.masterconfig.ProductsConfigService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ai.lentra.commons.ResponeGen.getResponse;
@Service
public class ProductConfigServiceImpl implements ProductsConfigService {

    @Autowired
    ProductConfigRepository repository;

    @Override
    public ResponseEntity<ResponseDTO> saveProduct(ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
            if(productsDTO.getProductType().trim().isEmpty() || productsDTO.getProfileName().trim().isEmpty()  ){
               
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Product Type / Profile name should not be blank ","ERROR"));
            }}
            catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Product Type / Profile name  should not be null ","ERROR"));
            }
            Optional<ProductConfigEntity> optionalRole = Optional.ofNullable(repository.findByProductType(productsDTO.getProductType()));
            if (optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(403,"This Product Already mapped with Another Profile ","ERROR"));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            ProductConfigEntity products = objectMapper.convertValue(productsDTO, ProductConfigEntity.class);

            repository.save(products);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Role has been added successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"Role already mapped ","ERROR"));
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> updateProduct(ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
                if(productsDTO.getProductType().trim().isEmpty() || productsDTO.getProfileName().trim().isEmpty()  ){
                   
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be blank ","ERROR"));
                }}

            catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be null ","ERROR"));
            }
            Optional<ProductConfigEntity> optionalRole = Optional.ofNullable(repository.findByProductId(productsDTO.getProductId()));
            if (!optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found ","ERROR"));
            }
            ProductConfigEntity existingProducts = optionalRole.get();
            if (productsDTO.getProductType() != null) {
                existingProducts.setProductType(productsDTO.getProductType());
            }
            if (productsDTO.getProfileName() != null) {
                existingProducts.setProfileName(productsDTO.getProfileName());
            }
            

            repository.save(existingProducts);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Role has been updated successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while updating role config ","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getAllProducts() throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
        List<ProductConfigEntity> productsEntity =repository.findAll();
            // return  repository.findAll() ; //ResponseEntity.status(HttpStatus.OK).body(a.getData());
           return ( productsEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404," no results" ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(productsEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while fetching role config data","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getProduct(Long productId ) throws ResourceNotFoundException, DuplicateResourceException
    {
        ProductConfigEntity productsEntity = repository.findByProductId(productId);
        return (productsEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found " ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(productsEntity));
    }

}
