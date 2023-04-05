/*
package ai.lentra;



import ai.lentra.controller.configuration.roles.RoleConfigController;
import ai.lentra.dto.CommitmentDTO;
import ai.lentra.dto.configuration.RolesDTO;
import ai.lentra.modal.Commitment;
import ai.lentra.modal.configuration.RolesEntity;
import ai.lentra.repository.configuration.RolesRepository;
import ai.lentra.service.configuration.roles.RolesConfigService;
import ai.lentra.serviceImpl.configuration.roles.RoleConfigServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@Scope("ai.lentra.service.*")
public class RoleConfigControllerTest {


    @Mock
    private RolesRepository rolesRepository;

    @InjectMocks
    private RoleConfigServiceImpl roleConfigServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    RolesConfigService rolesConfigService;
    @Autowired
    RoleConfigController roleConfigController;
    RolesDTO rolesDTO = new RolesDTO();
    RolesEntity rolesEntity = new RolesEntity();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void saveRoleTest() throws DuplicateResourceException, InvalidInputException{
        rolesDTO = dummyRolesDTO();
        RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);
        when(roleConfigServiceImpl.saveRole(rolesDTO)).thenReturn(roles.getCommitmentId());
        ResponseEntity<Object> response = roleConfigController.saveRole(rolesDTO);
        assertNotNull(response);
    }

    public RolesDTO dummyRolesDTO() {
        rolesDTO.setRoleName("TLI");
        rolesDTO.setVmsRoleName("TL External");
        rolesDTO.setStatus(true);
        return rolesDTO;

    }
}
*/
