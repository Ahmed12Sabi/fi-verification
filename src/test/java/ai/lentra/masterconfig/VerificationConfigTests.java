//
//package ai.lentra.masterconfig;
//
//
//import ai.lentra.core.test.TransactionalTestContainerSupport;
//import ai.lentra.dto.masterConfig.ProductsDTO;
//import ai.lentra.dto.responses.ResponseDTO;
//import ai.lentra.exceptions.DuplicateResourceException;
//import ai.lentra.exceptions.ResourceNotFoundException;
//import ai.lentra.modal.masterconfig.*;
//import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
//import ai.lentra.service.masterconfig.VerificationConfigService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@Scope("ai.lentra.service.*")
//public class VerificationConfigTests extends TransactionalTestContainerSupport {
//    @Autowired
//    VerificationConfigService service;
//
//    @Autowired
//    VerificationFormFieldsConfigRepository repository;
//
//    @Test
//    public void saveVerificationConfigTest() throws ResourceNotFoundException, DuplicateResourceException {
//
//        List<MasterVerificationConfiguration> masterConfigList = new ArrayList<>();
//
//        masterConfigList.add(dummyConfiguration());
//        ResponseEntity<ResponseDTO> response = service.addFields(masterConfigList);
//        when("Configuration has been added successfully").thenReturn(response.getBody().getMessage());
//        assertNotNull(response);
//
//    }
//
//    public MasterVerificationConfiguration dummyConfiguration(){
//        MasterVerificationConfiguration masterConfig = new MasterVerificationConfiguration();
////        masterConfig.setVerificationConfig();
//        masterConfig.seteSign(true);
//        masterConfig.setvType("V-TYpe");
//        masterConfig.setProfileId(1);
//        masterConfig.setCreated_by("createdby Agent");
//        masterConfig.setInstitutionId(1234);
//        masterConfig.setModified_by("ModifiedBy");
//        masterConfig.setMultiVerificationAllowed("yes");
//        masterConfig.setProfileName("profile1");
//        masterConfig.setUserType("user1");
//        masterConfig.setSubProfileName("subProfile1");
//        masterConfig.setRetrigerVerification(false);
//        masterConfig.setProductLevelLogic("abc");
//        masterConfig.setRetrigerVerification(false);
//        VerificationConfig config = new VerificationConfig();
//        config.setvType("v-Type1");
//        config.setvDescription("desc1");
//        config.setInstitute_id("1234");
//        List<VerificationFormConfig> formConfigList = new ArrayList<>();
//        VerificationFormConfig formConfig = new VerificationFormConfig();
//        formConfig.setFormId(23);
//        formConfig.setFormDescription("form1");
//        formConfig.setFormName("Form1");
//        formConfig.setInstitute_id("1234");
//        formConfigList.add(formConfig);
//        List<VerificationConfig> configList = new ArrayList<>();
//        configList.add(config);
//        masterConfig.setVerificationConfig(configList);
//        config.setVerificationFormConfig(formConfigList);
//        VerificationFormFieldsConfig fieldsConfig = new VerificationFormFieldsConfig();
//
//        return masterConfig;
//    }
//    @Test
//    public void getAllConfig()  throws ResourceNotFoundException, DuplicateResourceException{
//        ResponseEntity<ResponseDTO> response = service.getAll(1234);
//        when("OK").thenReturn(response.getStatusCode().toString());
//        assertNotNull(response);
//
//    }
//}
//
