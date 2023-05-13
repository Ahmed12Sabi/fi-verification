///*
//package ai.lentra.masterconfig;
//
//
//import ai.lentra.config.I18nMessageKeys;
//import ai.lentra.core.i18n.api.I18nHelper;
//import ai.lentra.core.test.TransactionalTestContainerSupport;
//import ai.lentra.dto.masterConfig.RolesDTO;
//import ai.lentra.dto.responses.ResponseDTO;
//import ai.lentra.exceptions.DuplicateResourceException;
//import ai.lentra.exceptions.ResourceNotFoundException;
//import ai.lentra.modal.masterconfig.RolesEntity;
//import ai.lentra.repository.masterconfig.RolesRepository;
//import ai.lentra.serviceImpl.masterconfig.RoleConfigServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.LocalDate;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.ZonedDateTime;
//import java.util.Date;
//import java.util.List;
//
//import static ai.lentra.commons.ResponeGen.getResponse;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//
//
//public class RoleConfigServiceImplTest extends TransactionalTestContainerSupport {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    RolesRepository rolesRepository;
//    @Autowired
//    RoleConfigServiceImpl roleConfigServiceImpl;
//    RolesDTO rolesDTO = new RolesDTO();
//    RolesEntity rolesEntity = new RolesEntity();
//
//    Long id=1l;
//
//    @Test
//    public void saveRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
//        RolesDTO rolesDTO = new RolesDTO();
//        rolesDTO.setRoleId(1l);
//        rolesDTO.setRoleName("TMI");
//        rolesDTO.setVmsRoleName("TM");
//        rolesDTO.setStatus(true);
//        rolesDTO.setInstituteId("1");
//        ObjectMapper objectMapper = new ObjectMapper();
//        RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);
//        ResponseEntity rolesEntity =roleConfigServiceImpl.saveRole(rolesDTO);
//        Assertions.assertEquals(201,rolesEntity.getStatusCodeValue());
//
//    }
//
//
//    @Test
//    public void updateRoleTest()  throws ResourceNotFoundException, DuplicateResourceException{
//        RolesDTO rolesDTO = new RolesDTO();
//        rolesDTO.setRoleId(1l);
//        rolesDTO.setRoleName("TME");
//        rolesDTO.setVmsRoleName("TE");
//        rolesDTO.setStatus(false);
//        rolesDTO.setInstituteId("1");
//        ResponseEntity rolesEntity =roleConfigServiceImpl.updateRole(rolesDTO);
//        Assertions.assertNotNull(rolesEntity);
//
//    }
//
//
//
//    public RolesEntity dummyRolesEntity() {
//        RolesDTO rolesDTO = new RolesDTO();
//        rolesEntity.setRoleName(rolesDTO.getRoleName());
//        rolesEntity.setVmsRoleName(rolesDTO.getVmsRoleName());
//        rolesEntity.setStatus(rolesDTO.getStatus());
//        rolesEntity.setInstituteId("1");
//        rolesRepository.save(rolesEntity);
//        return rolesEntity;
//
//    }
//
//    @Test
//    public void getRoleTest() throws ResourceNotFoundException, DuplicateResourceException {
//        rolesEntity = dummyRolesEntity();
//        Integer id = 1;
//        ResponseEntity response = roleConfigServiceImpl.getRole(id.longValue());
//        // ResponseEntity<Object> response = roleConfigServiceImpl.getRole();
//        Assertions.assertNotNull(response);
//    }
//
//    @Test
//    public void getAllRoles()  throws ResourceNotFoundException, DuplicateResourceException{
//        RolesEntity rolesEntity = dummyRolesEntity();
//        ResponseEntity response = roleConfigServiceImpl.getAllRoles();
//        assertNotNull(response);
//    }
//
//}*/
