package ai.lentra.service.masterconfig;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.ReportConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface ReportConfigService {
    List<String> findByInstitute(String instituteId);

    ResponseEntity<ResponseDTO> save(List<ReportConfig> reportConfig);

    ResponseEntity<ResponseDTO> findByInstituteAll(String instituteId);
}
