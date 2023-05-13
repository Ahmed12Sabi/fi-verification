//package ai.lentra.masterconfig;
//
//import ai.lentra.core.test.TransactionalTestContainerSupport;
//import ai.lentra.dto.responses.ResponseDTO;
//import ai.lentra.exceptions.ResourceNotFoundException;
//import ai.lentra.modal.masterconfig.ReportConfig;
//import ai.lentra.modal.masterconfig.ReportConfigFields;
//import ai.lentra.repository.masterconfig.ReportConfigRepository;
//import ai.lentra.service.masterconfig.ReportConfigService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@Scope("ai.lentra.service.*")
//public class ReportConfigTest extends TransactionalTestContainerSupport {
//
//    @Autowired
//    ReportConfigService service;
//
//    @Autowired
//    ReportConfigRepository repository;
//
//    @Test
//    public void findAll()  {
//        ReportConfig config = getDemoDetails();
//        ResponseEntity<ResponseDTO> response = service.findByInstituteAll("1234");
//        Assertions.assertNotNull(response);
//
//    }
//
//    @Test
//    public void saveDetails() throws ResourceNotFoundException {
//        List<ReportConfig> config =  new ArrayList<>();
//        config.add( getDemoDetails());
//        ResponseEntity<ResponseDTO> response = service.save(config);
//        Assertions.assertEquals(201,response.getStatusCodeValue());
//
//    }
//
//    private ReportConfig getDemoDetails() {
//        ReportConfig config = new ReportConfig();
//        config.setId(1);
//        config.setFormName("form1");
//        config.setInstituteId("1234");
//        List<ReportConfigFields> fields = new ArrayList<>();
//        ReportConfigFields field = new ReportConfigFields();
//        field.setFields("field1");
//        ReportConfigFields field1 = new ReportConfigFields();
//        field1.setFields("field2");
//        ReportConfigFields field2 = new ReportConfigFields();
//        field2.setFields("field3");
//        fields.add(field);
//        fields.add(field1);
//        fields.add(field2);
//        config.setFields(fields);
//        return config;
//    }
//}
