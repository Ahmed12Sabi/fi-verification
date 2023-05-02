package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.masterConfig.ProductsDTO;
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
               
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400, I18nHelper.msg(I18nMessageKeys.type_name_not_blank),"ERROR"));
            }}
            catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.type_name_not_null),"ERROR"));
            }
            Optional<ProductConfigEntity> optionalRole = Optional.ofNullable(repository.findByProductType(productsDTO.getProductType()));
            if (optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,I18nHelper.msg(I18nMessageKeys.already_mapped_profile),"ERROR"));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            ProductConfigEntity products = objectMapper.convertValue(productsDTO, ProductConfigEntity.class);

            repository.save(products);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,I18nHelper.msg(I18nMessageKeys.product_added),"CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,I18nHelper.msg(I18nMessageKeys.error_adding_product),"ERROR"));
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> updateProduct(ProductsDTO productsDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
                if(productsDTO.getProductType().trim().isEmpty() || productsDTO.getProfileName().trim().isEmpty()  ){
                   
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.type_name_not_blank),"ERROR"));
                }}

            catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,I18nHelper.msg(I18nMessageKeys.type_name_not_null),"ERROR"));
            }

            Optional<ProductConfigEntity> optionalProduct = Optional.ofNullable(repository.findByProductTypeAndProfileNameAndProductIdNotIn(productsDTO.getProductType(),productsDTO.getProfileName(),productsDTO.getProductId()));
            if (optionalProduct.isPresent()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,I18nHelper.msg(I18nMessageKeys.already_mapped_profile),"ERROR"));
            }
            /*Optional<ProductConfigEntity> duplicateRole = Optional.ofNullable(repository.findByProductTypeAndProfileName(productsDTO.getProductType(),productsDTO.getProfileName()));
            if (duplicateRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getResponse(403,"This Product Already mapped with Another Profile ","ERROR"));
            }*/
            Optional<ProductConfigEntity> optionalRole = Optional.ofNullable(repository.findByProductId(productsDTO.getProductId()));
            if (!optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,I18nHelper.msg(I18nMessageKeys.product_not_found),"ERROR"));
            }
            ProductConfigEntity existingProducts = optionalRole.get();
            if (productsDTO.getProductType() != null) {
                existingProducts.setProductType(productsDTO.getProductType());
            }
            if (productsDTO.getProfileName() != null) {
                existingProducts.setProfileName(productsDTO.getProfileName());
            }
            if (productsDTO.getInstituteId() != null) {
                existingProducts.setInstituteId(productsDTO.getInstituteId());
            }if (productsDTO.getMandatory() != null) {
                existingProducts.setMandatory(productsDTO.getMandatory());
            }if (productsDTO.getDataPopulated() != null) {
                existingProducts.setDataPopulated(productsDTO.getDataPopulated());
            }if (productsDTO.getWaiverAllowed() != null) {
                existingProducts.setWaiverAllowed(productsDTO.getWaiverAllowed());
            }

            repository.save(existingProducts);
            return ResponseEntity.status(HttpStatus.OK).body(getResponse(200,I18nHelper.msg(I18nMessageKeys.product_updated_successfully),"CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,I18nHelper.msg(I18nMessageKeys.error_updating_config)
                    ,"ERROR"));
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,I18nHelper.msg(I18nMessageKeys.error_fetching_data),"ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getProduct(Long productId ) throws ResourceNotFoundException, DuplicateResourceException
    {
        ProductConfigEntity productsEntity = repository.findByProductId(productId);
        return (productsEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,I18nHelper.msg(I18nMessageKeys.product_not_found),"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(productsEntity));
    }

}
