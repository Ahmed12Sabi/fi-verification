package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.ReportConfig;
import ai.lentra.modal.masterconfig.ReportConfigFields;
import ai.lentra.repository.masterconfig.ReportConfigFieldsRepository;
import ai.lentra.repository.masterconfig.ReportConfigRepository;
import ai.lentra.service.masterconfig.ReportConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportConfigServiceImpl implements ReportConfigService {
    @Autowired
    private JsonUtils1 jsonUtils;

    @Autowired
    private ReportConfigRepository repository;
    @Autowired
    private ReportConfigFieldsRepository reportConfigFieldsRepository;
    @Override
    public List<String> findByInstitute(String instituteId) {
        List<ReportConfig> reportConfig = repository.findByInstitute(instituteId);
        List<ReportConfigFields> fields=new ArrayList<>();
        reportConfig.stream().forEach(c->
                fields.addAll(reportConfigFieldsRepository.findByReportId(c.getId())));
        List<String> fieldNames = new ArrayList<String>();
        for (ReportConfigFields field: fields) {
            fieldNames.add(field.getFields());
        }
        return fieldNames;
    }

    @Override
    public ResponseEntity<ResponseDTO> save(List<ReportConfig> reportConfig) {

        reportConfig.stream().forEach(report->

                reportConfigFieldsRepository.saveAll(report.getFields())

        );
        List<ReportConfig> reportConfig1=   repository.saveAll(reportConfig);
        ResponseDTO response = new ResponseDTO();
        response.setData(reportConfig1);
        response.setStatus("201");
        response.setMessage("Data added successfully");
        response.setCode(HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Override
    public ResponseEntity<ResponseDTO> findByInstituteAll(String instituteId) {

        List<ReportConfig> reportConfig = repository.findByInstitute(instituteId);
        reportConfig.stream().forEach(c->
                c.setFields(reportConfigFieldsRepository.findByReportId(c.getId()))

        );

        ResponseDTO response = new ResponseDTO();
        response.setData(reportConfig);
        response.setStatus("200");
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }



}
