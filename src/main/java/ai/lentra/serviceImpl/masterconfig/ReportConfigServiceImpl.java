package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.modal.masterconfig.ReportConfig;
import ai.lentra.modal.masterconfig.ReportConfigFields;
import ai.lentra.repository.masterconfig.ReportConfigFieldsRepository;
import ai.lentra.repository.masterconfig.ReportConfigRepository;
import ai.lentra.service.masterconfig.ReportConfigService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> findByInstitute(Integer instituteId) {
        List<ReportConfig> reportConfig = repository.findByInstitute(instituteId);
        List<ReportConfigFields> fields=new ArrayList<>();
        reportConfig.stream().forEach(c->
                fields.addAll(reportConfigFieldsRepository.findByReportId(c.getId())));
        List<String> fieldNames = new ArrayList<String>();
        for (ReportConfigFields field: fields) {
         fieldNames.add(   field.getFields());
        }
        return fieldNames;
    }

    @Override
    public List<ReportConfig> save(List<ReportConfig> reportConfig) {

        reportConfig.stream().forEach(report->

                reportConfigFieldsRepository.saveAll(report.getFields())

                );
        repository.saveAll(reportConfig);

        return reportConfig;
    }

    @Override
    public List<ReportConfig> findByInstituteAll(Integer instituteId) {

        List<ReportConfig> reportConfig = repository.findByInstitute(instituteId);
        reportConfig.stream().forEach(c->
             c.setFields(reportConfigFieldsRepository.findByReportId(c.getId()))

        );

        return reportConfig;
    }



}
