package ai.lentra.masterconfig;
import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.ReportConfig;
import ai.lentra.modal.masterconfig.ReportConfigFields;
import ai.lentra.modal.masterconfig.VerificationFormFieldsConfig;
import ai.lentra.repository.masterconfig.ReportConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.masterconfig.ReportConfigService;
import ai.lentra.service.masterconfig.VerificationConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
@SpringBootTest
@Scope("ai.lentra.service.*")
public class ReportConfigTest extends TransactionalTestContainerSupport {

    @Autowired
    private ReportConfigService service;

    @Autowired
    private ReportConfigRepository repository;

    @Test
    public void findAll()  {
        ReportConfig config = getDemoDetails();
        ResponseEntity<ResponseDTO> response = service.findByInstituteAll("1234");
        when("OK").thenReturn(response.getStatusCode().toString());
        assertNotNull(response);

    }

    @Test
    public void saveDetails()  {
        List<ReportConfig> config =  new ArrayList<>();
        config.add( getDemoDetails());
        ResponseEntity<ResponseDTO> response = service.save(config);
        when("Report has been added successfully").thenReturn(response.getBody().getMessage());
        assertNotNull(response);

    }

    private ReportConfig getDemoDetails() {
        ReportConfig config = new ReportConfig();
        config.setId(1);
        config.setFormName("form1");
        config.setInstituteId("1234");
        List<ReportConfigFields> fields = new ArrayList<>();
        ReportConfigFields field = new ReportConfigFields();
        field.setFields("field1");
        ReportConfigFields field1 = new ReportConfigFields();
        field1.setFields("field2");
        ReportConfigFields field2 = new ReportConfigFields();
        field2.setFields("field3");
        fields.add(field);
        fields.add(field1);
        fields.add(field2);
        config.setFields(fields);
        return config;
    }
}
