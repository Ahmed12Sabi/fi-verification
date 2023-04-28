package ai.lentra.controller.notification;

import ai.lentra.commons.TokenAuth;
import ai.lentra.controller.masterConfig.VerificationConfigController;
import ai.lentra.dto.notification.EMAIL.EmailRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
    @Autowired
    TokenAuth tokenAuth;
    private static final Logger logger =  LoggerFactory.getLogger(EmailController.class);
    @PostMapping(value = "/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request,
                                       @RequestHeader(value = "Content-Type", required = true) String contentType,
                                       @RequestHeader(value = "token", required = false) String token,
                                       @RequestHeader(value = "sLoginId", required = true) String sLoginId,
                                       @RequestHeader(value = "sPassword", required = true) String sPassword,
                                       @RequestHeader(value = "sInstituteName", required = true) String sInstituteName,
                                       @RequestHeader(value = "sApplicationId", required = true) String sApplicationId,
                                       @RequestHeader(value = "sSourceSystem", required = true) String sSourceSystem,
                                       @RequestHeader(value = "sProduct", required = true) String sProduct) {
        logger.info("Entered into sendEmail");
        RestTemplate template = new RestTemplate();
        String emailUrl = "https://ssguat.serviceurl.in/hubx/send-mail";
        String genToken= tokenAuth.getToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", genToken);
        headers.set("sLoginId", sLoginId);
        headers.set("sPassword", sPassword);
        headers.set("sInstituteName", sInstituteName);
        headers.set("sApplicationId", sApplicationId);
        headers.set("sSourceSystem", sSourceSystem);
        headers.set("sProduct", sProduct);
        System.out.println(headers);
        HttpEntity<EmailRequest> entityReq = new HttpEntity<EmailRequest>(request, headers);
        ResponseEntity<String> response= template.exchange(emailUrl, HttpMethod.POST, entityReq, String.class);
        return response;
    }
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAuthToken(){
       return ResponseEntity.ok(tokenAuth.getToken());
    }

}
