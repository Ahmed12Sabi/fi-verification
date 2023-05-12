package ai.lentra.controller.reportParsing;

import ai.lentra.service.masterconfig.ReportConfigService;
import ai.lentra.service.reportparsing.DownloadReportService;
import ai.lentra.service.reportparsing.ReportParsingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportParsingController {
    private static final Logger logger =  LoggerFactory.getLogger(ReportParsingController.class);
    @Autowired
    private ReportConfigService reportConfigService;
    @Autowired
    private DownloadReportService downloadReportService;

    @Autowired
    private ReportParsingService reportParsingService;

    @PostMapping(value="" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFilesOnline(@RequestHeader(name = "institution-id") String institutionId,
                                               @RequestBody MultipartFile file) throws IOException {

        logger.info("Entered into uploadFilesOnline ");
        return reportParsingService.uploadReport(file, institutionId);
    }

    @GetMapping("")
    public ResponseEntity<?> getCsv(
            @RequestHeader(name = "Content-Disposition") final String fileName,

            @RequestHeader(name = "Content-Type") final String mediaType,
            @RequestHeader(name = "institution-id") String institutionId) throws IOException {
        logger.info("Entered into getCsv ");
        List<String> fields = reportConfigService.findByInstitute(institutionId);
        final InputStreamResource resource = new InputStreamResource( downloadReportService.load(fields, fileName));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, fileName)
                .contentType(MediaType.parseMediaType(mediaType))
                .body(resource);
    }
}
