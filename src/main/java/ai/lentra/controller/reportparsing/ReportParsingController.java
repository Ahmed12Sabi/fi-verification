package ai.lentra.controller.reportparsing;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.service.masterconfig.ReportConfigService;
import ai.lentra.service.reportparsing.DownloadReportService;
import ai.lentra.service.reportparsing.ReportParsingService;
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
    @Autowired
    private ReportConfigService reportConfigService;
    @Autowired
    private DownloadReportService downloadReportService;

    @Autowired
    private ReportParsingService reportParsingService;

    @PostMapping(value="/upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFilesOnline(@RequestHeader(value="institution_id", required = true) Integer institutionId,
                                                         @RequestBody MultipartFile file) throws IOException {


        return reportParsingService.uploadReport(file, institutionId);
    }

    @GetMapping("/download/{institutionId}")
    public ResponseEntity<?> getCsv(
            @RequestHeader(name = "Content-Disposition") final String fileName,

            @RequestHeader(name = "Content-Type") final String mediaType,
            @PathVariable Integer institutionId) {
        System.out.println(institutionId+"Institute");
        List<String> fields = reportConfigService.findByInstitute(institutionId);
        final InputStreamResource resource = new InputStreamResource( downloadReportService.load(fields));
       return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, fileName)
                .contentType(MediaType.parseMediaType(mediaType))
                .body(resource);
    }
}
