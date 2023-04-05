package ai.lentra.masterconfig;

import ai.lentra.dto.masterconfig.VerificationFormFieldResponse;


import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterConfigTests {

    @Autowired
    private VerificationConfigService service;

    @MockBean
    private VerificationFormFieldsConfigRepository repository;
    @Test
    public void findAll()  {
        VerificationFormFieldsConfig verificationFormFieldResponse = getDemoDetails();
        when(repository.findAll()).thenReturn(
                (List<VerificationFormFieldsConfig>) Stream.of(verificationFormFieldResponse,
                        verificationFormFieldResponse).collect(Collectors.toList()));
              assertEquals(2,repository.findAll().size());

    }

    private VerificationFormFieldsConfig getDemoDetails() {
        VerificationFormFieldsConfig demo = new VerificationFormFieldsConfig();
        demo.setFieldName("feild1");
        demo.setRequired(true);
        demo.setFieldId(111);
        demo.setStatus(true);
        demo.setHidden(false);
       demo.setDataAutoPopulation(true);
       demo.setFieldType("type1");
        return  demo;
    }


}
