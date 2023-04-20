package ai.lentra.controller.offlineVerification;

import ai.lentra.service.offlineVerification.OfflineVerificationService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class OfflineVerificationController {

    @Autowired
    OfflineVerificationService offlineVerificationService;
    @GetMapping("/download-pdf")
    public String getOffLinePDF(HttpServletResponse response) throws Exception{

    return offlineVerificationService.getOffLinePDF(response);
    }

}

