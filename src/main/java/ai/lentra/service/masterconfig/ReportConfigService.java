package ai.lentra.service.masterconfig;

import ai.lentra.modal.masterconfig.ReportConfig;

import java.util.List;

public interface ReportConfigService {
    List<String> findByInstitute(Integer instituteId);

    List<ReportConfig> save(List<ReportConfig> reportConfig);

    List<ReportConfig> findByInstituteAll(Integer instituteId);
}
