
package ai.lentra;



import ai.lentra.controller.configuration.roles.RoleConfigController;

import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.masterConfig.RolesDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.RolesEntity;
import ai.lentra.repository.masterconfig.RolesRepository;
import ai.lentra.service.masterconfig.RolesConfigService;
import ai.lentra.serviceImpl.masterconfig.RoleConfigServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;


@SpringBootTest
@Scope("ai.lentra.service.*")
public class RoleConfigControllerTest extends TransactionalTestContainerSupport {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RoleConfigServiceImpl roleConfigServiceImpl;


    @Autowired
    RolesConfigService rolesConfigService;
    @Autowired
    RoleConfigController roleConfigController;
    RolesDTO rolesDTO = new RolesDTO();
    RolesEntity rolesEntity = new RolesEntity();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void saveRoleTest() throws DuplicateResourceException, InvalidInputException, ResourceNotFoundException {
        rolesDTO = dummyRolesDTO();
        RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);
      // when(roleConfigServiceImpl.saveRole(rolesDTO)).thenReturn(dummyRolesDTO());
      // ResponseEntity<Object> response = roleConfigController.saveRole(rolesDTO);
      //  assertNotNull(response);
    }

    public RolesDTO dummyRolesDTO() {
        rolesDTO.setRoleName("TLI");
        rolesDTO.setVmsRoleName("TL External");
        rolesDTO.setStatus(true);
        return rolesDTO;

    }
}

