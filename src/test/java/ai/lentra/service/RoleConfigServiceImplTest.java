
package ai.lentra.service;


import ai.lentra.core.authz.internal.model.Role;
import ai.lentra.dto.masterconfig.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;

import ai.lentra.modal.masterconfig.RolesEntity;
import ai.lentra.repository.masterconfig.RolesRepository;
import ai.lentra.serviceImpl.masterconfig.RoleConfigServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@Scope("ai.lentra.service.*")
public class RoleConfigServiceImplTest {
    @MockBean
    RolesRepository rolesRepository;
    @MockBean
    RoleConfigServiceImpl roleConfigServiceImpl;
    RolesDTO rolesDTO = new RolesDTO();
    RolesEntity rolesEntity = new RolesEntity();

    @Test
    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        RolesEntity rolesEntity = dummyRolesEntity();
        RolesDTO rolesDTO = dummyRolesDTO();
        ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.saveRole(rolesDTO);
        when(response).thenReturn(any());
        assertNotNull(response);

    }
    @Test
    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
        RolesEntity rolesEntity = dummyRolesEntity();
        RolesDTO rolesDTO = updateDummyRolesDTO();
        ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.saveRole(rolesDTO);
        when(rolesEntity).thenReturn(rolesEntity);
        assertNotNull(response);

    }
    public RolesDTO dummyRolesDTO() {
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setRoleName("TMI");
        rolesDTO.setVmsRoleName("TM");
        rolesDTO.setStatus(true);
        return rolesDTO;
    }

    public RolesDTO updateDummyRolesDTO() {
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setRoleId(1);
        rolesDTO.setRoleName("TMI");
        rolesDTO.setVmsRoleName("TM");
        rolesDTO.setStatus(true);
        return rolesDTO;
    }

    public RolesEntity dummyRolesEntity() {
        RolesDTO rolesDTO = new RolesDTO();
        rolesEntity.setRoleName(rolesDTO.getRoleName());
        rolesEntity.setVmsRoleName(rolesDTO.getVmsRoleName());
        rolesEntity.setStatus(rolesDTO.getStatus());
        rolesRepository.save(rolesEntity);
        return rolesEntity;

    }

    @Test
    public void getRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        rolesEntity = dummyRolesEntity();
        Integer id = 1;
        ResponseEntity<Object> response = roleConfigServiceImpl.getRole(id.longValue());
        when(rolesRepository.getById(1)).thenReturn(any());
        Assertions.assertNotNull(rolesEntity);
        Assertions.assertNotNull(response);
    }

    @Test
    public void getAllRoles() {
        RolesEntity rolesEntity = dummyRolesEntity();
        List<RolesEntity> rolesEntities = rolesRepository.findAll();
        when(rolesRepository.findAll()).thenReturn(rolesEntities);
        List<RolesEntity> response = rolesRepository.findAll();
        assertNotNull(response);
    }

}
