package ai.lentra.masterconfig;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportConfigTest {

    @Autowired
    private ReportConfigService service;

    @MockBean
    private ReportConfigRepository repository;

    @Test
    public void findAll()  {
        ReportConfig config = getDemoDetails();
        when(repository.findByInstitute(1234)).thenReturn(
                (List<ReportConfig>) Stream.of(config,
                        config).collect(Collectors.toList()));
        assertEquals(2,repository.findByInstitute(1234).size());

    }

    @Test
    public void saveDetails()  {
        ReportConfig config = getDemoDetails();
        when(repository.save(config)).thenReturn(
                config);
        assertEquals(1,repository.save(config));

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
