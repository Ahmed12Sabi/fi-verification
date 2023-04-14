package ai.lentra.controller.masterConfig;

import ai.lentra.modal.masterconfig.ReportConfig;
import ai.lentra.service.masterconfig.ReportConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports/config")
public class ReportConfigController {
    @Autowired
    private ReportConfigService reportConfigService;

    @GetMapping("/get/{institutionId}")
    public List<ReportConfig> getConfig(
            @PathVariable Integer institutionId) {
    return reportConfigService.findByInstituteAll(institutionId);
    }

    @PostMapping("/save")
    public List<ReportConfig> saveConfig(
            @RequestHeader (value = "Content-Type", required = true) String contentType,
                                      @RequestBody List<ReportConfig> reportConfig) {
        return reportConfigService.save(reportConfig);
    }
    }