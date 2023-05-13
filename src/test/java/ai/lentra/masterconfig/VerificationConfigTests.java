
package ai.lentra.masterconfig;


import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.masterConfig.ProductsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.*;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Scope("ai.lentra.service.*")
public class VerificationConfigTests extends TransactionalTestContainerSupport {
    @Autowired
    VerificationConfigService service;

    @Autowired
    VerificationFormFieldsConfigRepository repository;

    @Test
    public void saveVerificationConfigTest() throws ResourceNotFoundException, DuplicateResourceException {

        List<MasterVerificationConfiguration> masterConfigList = new ArrayList<>();

        masterConfigList.add(dummyConfiguration());
        ResponseEntity<ResponseDTO> response = service.addFields(masterConfigList);

        Assertions.assertEquals(201,response.getStatusCodeValue());

    }


    @Test
    public void getConfigTest()  {
        MasterVerificationConfiguration masterConfig = dummyConfiguration();
        Integer id = 1;
        ResponseEntity response = service.getAll(1234);
        // ResponseEntity<Object> response = roleConfigServiceImpl.getRole();
        Assertions.assertNotNull(response);
    }

    public MasterVerificationConfiguration dummyConfiguration(){
        MasterVerificationConfiguration masterConfig = new MasterVerificationConfiguration();
//        masterConfig.setVerificationConfig();
        masterConfig.setModified_by("user1");
        masterConfig.setInstituteId("1234");
        masterConfig.setProductType("HL");
        masterConfig.setProfileName("profile1");
        masterConfig.setId(1);
        masterConfig.setCreated_by("user1");
        VerificationConfig config = new VerificationConfig();
        config.setvType("v-Type1");
        config.setvId(1);
        config.setEsign(true);
        config.setMultiVerificationAllowed("no");
        config.setRetrigerVerification(true);
        config.setSubProfileName("sub -profile1");
        config.setUserType("internal");
        List<VerificationFormConfig> formConfigList = new ArrayList<>();
        VerificationFormConfig formConfig = new VerificationFormConfig();
        formConfig.setFormId(23);
        formConfig.setFormName("form1");
        formConfigList.add(formConfig);
        VerificationFormFieldsConfig fieldsConfig = new VerificationFormFieldsConfig();
        fieldsConfig.setFieldId(1);
        fieldsConfig.setFieldName("fields1");
        List<VerificationFormFieldsConfig> fieldsConfigList = new ArrayList<>();
        fieldsConfigList.add(fieldsConfig);
        formConfig.setVerificationFormFieldsConfig(fieldsConfigList);
        List<VerificationConfig> configList = new ArrayList<>();
        config.setVerificationFormConfig(formConfigList);
        configList.add(config);
        masterConfig.setVerificationConfig(configList);

        return masterConfig;
    }
   /* @Test
    public void getAllConfig()  throws ResourceNotFoundException, DuplicateResourceException{
        ResponseEntity<ResponseDTO> response = service.getAll(1234);
        when("OK").thenReturn(response.getStatusCode().toString());
        assertNotNull(response);

    }*/
}

