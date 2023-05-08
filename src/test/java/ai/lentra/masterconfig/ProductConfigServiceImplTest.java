
package ai.lentra.masterconfig;


import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.masterConfig.ProductsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.ProductConfigEntity;
import ai.lentra.repository.masterconfig.ProductConfigRepository;
import ai.lentra.serviceImpl.masterconfig.ProductConfigServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;



public class ProductConfigServiceImplTest extends TransactionalTestContainerSupport {

    @Autowired
    private ProductConfigRepository repository;

    @Autowired
    ProductConfigServiceImpl productConfigServiceImpl;

    ProductConfigEntity productsEntity = new ProductConfigEntity();

    @Test
    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductType("HL");
        productsDTO.setProfileName("Profile1");
        productsDTO.setInstituteId("1");
        productsDTO.setWaiverAllowed(true);
        productsDTO.setDataPopulated(true);
        productsDTO.setMandatory(true);
        ResponseEntity<ResponseDTO> response = productConfigServiceImpl.saveProduct(productsDTO);
        when("Product has been added successfully").thenReturn(response.getBody().getMessage());
        assertNotNull(response);

    }
    @Test
    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductType("HL");
        productsDTO.setProfileName("Profile2");
        productsDTO.setInstituteId("1");
        productsDTO.setWaiverAllowed(true);
        productsDTO.setDataPopulated(true);
        productsDTO.setMandatory(true);
        ResponseEntity<ResponseDTO> response = productConfigServiceImpl.saveProduct(productsDTO);
        when("Product has been updated successfully").thenReturn(response.getBody().getMessage());
        assertNotNull(response);

    }

    @Test
    public void getAllProducts()  throws ResourceNotFoundException, DuplicateResourceException{
        ProductConfigEntity productsEntity = dummyProductConfigEntity();

        ResponseEntity<Object> response = productConfigServiceImpl.getAllProducts();
        when("OK").thenReturn(response.getStatusCode().toString());
        assertNotNull(response);

    }
    public ProductsDTO dummyProductsDTO() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductType("HL");
        productsDTO.setProfileName("Profile1");
        productsDTO.setInstituteId("1");
        productsDTO.setWaiverAllowed(true);
        productsDTO.setDataPopulated(true);
        productsDTO.setMandatory(true);
        return productsDTO;
    }

    public ProductsDTO updateDummyProductsDTO() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductType("HL");
        productsDTO.setProfileName("Profile1");
        productsDTO.setInstituteId("1");
        return productsDTO;
    }

    public ProductConfigEntity dummyProductConfigEntity() {
        ProductConfigEntity productsDTO = new ProductConfigEntity();
        productsDTO.setProductType(productsDTO.getProductType());
        productsDTO.setProfileName(productsDTO.getProfileName());
        productsDTO.setInstituteId(productsDTO.getInstituteId());
        productsDTO.setWaiverAllowed(productsDTO.getWaiverAllowed());
        productsDTO.setDataPopulated(productsDTO.getDataPopulated());
        productsDTO.setMandatory(productsDTO.getMandatory());
        return repository.save(productsDTO);

    }

    @Test
    public void getProductTest() throws ResourceNotFoundException, DuplicateResourceException {
        productsEntity = dummyProductConfigEntity();
        Integer id = 1;
        ResponseEntity<Object> response = productConfigServiceImpl.getProduct(id.longValue());
        when(repository.getById(1)).thenReturn(productsEntity);
        Assertions.assertNotNull(productsEntity);
        Assertions.assertNotNull(response);
    }



}

