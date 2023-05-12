
package ai.lentra.masterconfig;


import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.masterConfig.RolesDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static ai.lentra.commons.ResponeGen.getResponse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



public class RoleConfigServiceImplTest extends TransactionalTestContainerSupport {
    @Autowired
    RolesRepository service;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    RoleConfigServiceImpl roleConfigServiceImpl;
    RolesDTO rolesDTO = new RolesDTO();
    RolesEntity rolesEntity = new RolesEntity();

    @Test
    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        RolesEntity rolesDTO = new RolesEntity();
        rolesDTO.setRoleId(1);
        rolesDTO.setRoleName("TMI");
        rolesDTO.setVmsRoleName("TM");
        rolesDTO.setStatus(true);
        rolesDTO.setInstituteId("1");

        RolesEntity rolesEntity =rolesRepository.save(rolesDTO);
      //  ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.saveRole(rolesDTO);
        RolesEntity res =rolesRepository.getById(1);
        Assertions.assertEquals("TMI", res.getRoleName());
        Assertions.assertEquals("TM", res.getVmsRoleName());
        Assertions.assertEquals(true, res.getStatus());
        Assertions.assertEquals("1", res.getInstituteId());
     }


    @Test
    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setRoleName("TME");
        rolesDTO.setVmsRoleName("TE");
        rolesDTO.setStatus(false);
        rolesDTO.setInstituteId("1");
        ResponseEntity<ResponseDTO> response = roleConfigServiceImpl.updateRole(rolesDTO);
        RolesEntity res =rolesRepository.getById(1);
        Assertions.assertEquals("TME", res.getRoleName());
        Assertions.assertEquals("TE", res.getVmsRoleName());
        Assertions.assertEquals(false, res.getStatus());
        Assertions.assertEquals("1", res.getInstituteId());

    }



    public RolesEntity dummyRolesEntity() {
        RolesDTO rolesDTO = new RolesDTO();
        rolesEntity.setRoleName(rolesDTO.getRoleName());
        rolesEntity.setVmsRoleName(rolesDTO.getVmsRoleName());
        rolesEntity.setStatus(rolesDTO.getStatus());
        rolesEntity.setInstituteId("1");
        rolesRepository.save(rolesEntity);
        return rolesEntity;

    }

    @Test
    public void getRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
        rolesEntity = dummyRolesEntity();
        Integer id = 1;
        ResponseEntity<Object> response = roleConfigServiceImpl.getRole(id.longValue());
        Assertions.assertNotNull(response);
    }

    @Test
    public void getAllRoles() {
        RolesEntity rolesEntity = dummyRolesEntity();
        List<RolesEntity> response = rolesRepository.findAll();
        assertNotNull(response);
    }

}
