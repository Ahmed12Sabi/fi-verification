/*
package ai.lentra.service;

import ai.lentra.dto.configuration.ProductsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.configuration.ProductConfigEntity;
import ai.lentra.repository.verification_type.ProductRepository;
import ai.lentra.serviceImpl.configuration.roles.RoleConfigServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
    ProductRepository productsRepository;
    @Autowired
    RoleConfigServiceImpl roleConfigServiceImpl;
    ProductsDTO productsDTO = new ProductsDTO();
    ProductConfigEntity productsEntity = new ProductConfigEntity();

    @Test
    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = dummyProductsDTO();
        ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.saveRole(productsDTO);
        when(productsEntity).thenReturn(productsEntity);
        assertNotNull(response);

    }
    @Test
    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
        ProductConfigEntity productsEntity = dummyProductConfigEntity();
        ProductsDTO productsDTO = updateDummyProductsDTO();
        ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.saveRole(productsDTO);
        when(productsEntity).thenReturn(productsEntity);
        assertNotNull(response);

    }
    public ProductsDTO dummyProductsDTO() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setRoleName("TMI");
        productsDTO.setVmsRoleName("TM");
        productsDTO.setStatus(true);
        return productsDTO;
    }

    public ProductsDTO updateDummyProductsDTO() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setRoleId(1);
        productsDTO.setRoleName("TMI");
        productsDTO.setVmsRoleName("TM");
        productsDTO.setStatus(true);
        return productsDTO;
    }

    public ProductConfigEntity dummyProductConfigEntity() {
        ProductsDTO productsDTO = new ProductsDTO();
        productsEntity.setRoleName(productsDTO.getRoleName());
        productsEntity.setVmsRoleName(productsDTO.getVmsRoleName());
        productsEntity.setStatus(productsDTO.getStatus());
        productsRepository.save(productsEntity);
        return productsEntity;

    }

    @Test
    public void getRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        productsEntity = dummyProductConfigEntity();
        Integer id = 1;
        ResponseEntity<Object> response = roleConfigServiceImpl.getRole(id.longValue());
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
*/
