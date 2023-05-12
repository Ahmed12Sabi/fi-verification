package ai.lentra.service.reportparsing;

import ai.lentra.dto.responses.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface ReportParsingService{

    ResponseEntity<?> uploadReport(MultipartFile file, String institutionId);
}
