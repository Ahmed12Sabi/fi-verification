package ai.lentra.controller.masterConfig;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.ReportConfig;
import ai.lentra.service.masterconfig.ReportConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report-configs")
public class ReportConfigController {
    @Autowired
    private ReportConfigService reportConfigService;
    private static final Logger logger =  LoggerFactory.getLogger(ReportConfigController.class);

    @GetMapping("/{institutionId}")
    public ResponseEntity<ResponseDTO> getConfig(
            @PathVariable String institutionId) {
        logger.info("Entered into getConfig ");
        return reportConfigService.findByInstituteAll(institutionId);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO> saveConfig(
            @RequestHeader (value = "Content-Type", required = true) String contentType,
            @RequestBody List<ReportConfig> reportConfig) {
        logger.info("Entered into saveConfig ");
        return reportConfigService.save(reportConfig);
    }
}