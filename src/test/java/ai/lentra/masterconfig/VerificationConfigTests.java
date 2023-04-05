package ai.lentra.masterconfig;

import ai.lentra.dto.masterconfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterconfig.VerificationFormConfigDto;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.modal.masterconfig.VerificationFormConfig;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerificationConfigTests {
@Autowired
    VerificationConfigService service;
@MockBean
VerificationFormFieldsConfigRepository repository;

    @Test
    public void findAll()  {
        VerificationFormFieldsConfig formConfig = getDemoDetails();

        when(repository.findAll()).thenReturn(
                (List<VerificationFormFieldsConfig>) Stream.of(formConfig, formConfig).collect(Collectors.toList())
        );
        assertEquals(2,repository.findAll().size());

    }


    @Test
    public void findSummaryByAppIdTest() {
        Integer applicantId = 23;
        VerificationFormFieldsConfig formFieldsConfig = getDemoDetails();
        VerificationFormFieldsConfigDto formFieldsConfigDto = getDemoDtoDetails();
        when(repository.findById(formFieldsConfig.getFieldId())).thenReturn(Optional.of(formFieldsConfig));
        assertEquals(formFieldsConfig, service.updateFields(formFieldsConfigDto));
    }

    private VerificationFormFieldsConfigDto getDemoDtoDetails() {
        VerificationFormFieldsConfigDto verificationFormFieldsConfigDto = new VerificationFormFieldsConfigDto();
        verificationFormFieldsConfigDto.setFieldType("qwq1");
        verificationFormFieldsConfigDto.setFieldName("abvcd");
        verificationFormFieldsConfigDto.setFieldId(1111);
        verificationFormFieldsConfigDto.setHidden(false);
        verificationFormFieldsConfigDto.setScoring(true);
        verificationFormFieldsConfigDto.setDataAutoPopulation(true);
        verificationFormFieldsConfigDto.setLookTable("loohup");
        verificationFormFieldsConfigDto.setLookUp(true);
        verificationFormFieldsConfigDto.setRequired(false);
        verificationFormFieldsConfigDto.setMaxLength(13233);
        verificationFormFieldsConfigDto.setMaxLength(34567890);
        verificationFormFieldsConfigDto.setMaxRange(345);
        verificationFormFieldsConfigDto.setMaxRange(234567890);
        MasterVerificationConfigurationDto master = new MasterVerificationConfigurationDto();
        master.setId(123);
        master.setRetrigerVerification(false);
        master.setMultiVerificationAllowed("sdgvcuds");
        master.setProfileId(2443);
        master.setVType("fi");
        master.setUserType("new");
        verificationFormFieldsConfigDto.setMasterVerificationConfiguration(master);
                VerificationFormConfigDto v1= new VerificationFormConfigDto();
                v1.setFormId(1);
                v1.setFormName("dguwe");
                v1.setFormDescription("shdcu");
                verificationFormFieldsConfigDto.setVerificationFormConfig(v1);
                return verificationFormFieldsConfigDto;

    }



    private VerificationFormFieldsConfig getDemoDetails() {

        VerificationFormFieldsConfig verificationFormFieldsConfigDto = new VerificationFormFieldsConfig();
        verificationFormFieldsConfigDto.setFieldType("qwq1");
        verificationFormFieldsConfigDto.setFieldName("abvcd");
        verificationFormFieldsConfigDto.setFieldId(1111);
        verificationFormFieldsConfigDto.setHidden(false);
        verificationFormFieldsConfigDto.setScoring(true);
        verificationFormFieldsConfigDto.setDataAutoPopulation(true);
        verificationFormFieldsConfigDto.setLookTable("loohup");
        verificationFormFieldsConfigDto.setLookUp(true);
        verificationFormFieldsConfigDto.setRequired(false);
        verificationFormFieldsConfigDto.setMaxLength(13233);
        verificationFormFieldsConfigDto.setMaxLength(34567890);
        verificationFormFieldsConfigDto.setMaxRange(345);
        verificationFormFieldsConfigDto.setMaxRange(234567890);
        MasterVerificationConfiguration master = new MasterVerificationConfiguration();
        master.setId(123);
        master.setRetrigerVerification(false);
        master.setMultiVerificationAllowed("sdgvcuds");
        master.setProfileId(2443);
        master.setVType("fi");
        master.setUserType("new");
        verificationFormFieldsConfigDto.setMasterVerificationConfiguration(master);
        VerificationFormConfig v1= new VerificationFormConfig();
        v1.setFormId(1);
        v1.setFormName("dguwe");
        v1.setFormDescription("shdcu");
        verificationFormFieldsConfigDto.setVerificationFormConfig(v1);
        return verificationFormFieldsConfigDto;
    }
}
