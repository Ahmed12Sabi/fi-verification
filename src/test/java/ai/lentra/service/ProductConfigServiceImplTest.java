
package ai.lentra.service;

import ai.lentra.dto.masterConfig.ProductsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.ProductConfigEntity;
import ai.lentra.repository.masterconfig.ProductConfigRepository;
import ai.lentra.serviceImpl.masterconfig.ProductConfigServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
@Scope("ai.lentra.service.*")
public class ProductConfigServiceImplTest {
    @MockBean
    ProductConfigRepository productsRepository;
    @MockBean
    ProductConfigServiceImpl productConfigServiceImpl;

    ProductsDTO productsDTO = new ProductsDTO();
    ProductConfigEntity productsEntity = new ProductConfigEntity();

    @Test
    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = dummyProductsDTO();
        ResponseEntity<ResponseDTO> response = productConfigServiceImpl.saveProduct(productsDTO);
        when(productsEntity).thenReturn(productsEntity);
        assertNotNull(response);

    }
    @Test
    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = updateDummyProductsDTO();
        ResponseEntity<ResponseDTO> response = productConfigServiceImpl.saveProduct(productsDTO);
        when(productsEntity).thenReturn(productsEntity);
        assertNotNull(response);

    }
    public ProductsDTO dummyProductsDTO() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductType("HL");
        productsDTO.setProfileName("Profile1");
        productsDTO.setInstituteId("1");
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
        productsRepository.save(productsDTO);
        return productsEntity;

    }

    @Test
    public void getRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        productsEntity = dummyProductConfigEntity();
        Integer id = 1;
        ResponseEntity<Object> response = productConfigServiceImpl.getProduct(id.longValue());
        when(productsRepository.getById(1)).thenReturn(productsEntity);
        Assertions.assertNotNull(productsEntity);
        Assertions.assertNotNull(response);
    }

    @Test
    public void getAllProducts() {
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        List<ProductConfigEntity> productsEntities = productsRepository.findAll();
        when(productsRepository.findAll()).thenReturn(productsEntities);
        List<ProductConfigEntity> response = productsRepository.findAll();
        assertNotNull(response);
    }

}

