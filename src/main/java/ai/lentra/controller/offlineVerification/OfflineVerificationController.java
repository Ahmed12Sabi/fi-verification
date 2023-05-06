package ai.lentra.controller.offlineVerification;

import ai.lentra.controller.notification.UserRoleController;
import ai.lentra.service.offlineVerification.OfflineVerificationService;
//import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class OfflineVerificationController {
    private static final Logger logger =  LoggerFactory.getLogger(OfflineVerificationController.class);
    @Autowired
    OfflineVerificationService offlineVerificationService;
    @GetMapping("/download-pdf")
    public String getOffLinePDF(HttpServletRequest request) throws Exception{
        logger.info("Entered into getOffLinePDF ");
    return offlineVerificationService.getOffLinePDF(request);
    }

}

