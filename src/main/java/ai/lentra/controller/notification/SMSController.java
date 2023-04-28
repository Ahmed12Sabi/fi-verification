package ai.lentra.controller.notification;

import ai.lentra.commons.TokenAuth;
import ai.lentra.controller.masterConfig.VerificationConfigController;
import ai.lentra.dto.notification.SMS.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/sms")
public class SMSController {
    private static final Logger logger =  LoggerFactory.getLogger(SMSController.class);
@Autowired
    TokenAuth tokenAuth;
    @PostMapping(value = "/sendSms")
    public ResponseEntity<?> sendSms(@RequestBody SmsRequest request, @RequestHeader(value = "Content-Type", required = true) String contentType, @RequestHeader(value = "token", required = false) String token, @RequestHeader(value = "sLoginId", required = true) String sLoginId, @RequestHeader(value = "sPassword", required = true) String sPassword, @RequestHeader(value = "sInstituteName", required = true) String sInstituteName, @RequestHeader(value = "sApplicationId", required = true) String sApplicationId, @RequestHeader(value = "sSourceSystem", required = true) String sSourceSystem, @RequestHeader(value = "sProduct", required = true) String sProduct) {
        logger.info("Entered into sendSms");
        String smsUrl = "https://ssguat.serviceurl.in/hubx/send-sms/v2";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", tokenAuth.getToken());
        headers.set("sLoginId", sLoginId);
        headers.set("sPassword", sPassword);
        headers.set("sInstituteName", sInstituteName);
        headers.set("sApplicationId", sApplicationId);
        headers.set("sSourceSystem", sSourceSystem);
        headers.set("sProduct", sProduct);
        System.out.println(headers);
        HttpEntity<SmsRequest> entityReq = new HttpEntity<SmsRequest>(request, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> respEntity = template.exchange(smsUrl, HttpMethod.POST, entityReq, String.class);
        return respEntity;
    }



}
