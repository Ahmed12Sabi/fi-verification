package ai.lentra.controller.notification;

import ai.lentra.dto.notification.EMAIL.EmailRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @PostMapping(value = "/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request, @RequestHeader(value = "Content-Type", required = true) String contentType, @RequestHeader(value = "token", required = false) String token, @RequestHeader(value = "sLoginId", required = true) String sLoginId, @RequestHeader(value = "sPassword", required = true) String sPassword, @RequestHeader(value = "sInstituteName", required = true) String sInstituteName, @RequestHeader(value = "sApplicationId", required = true) String sApplicationId, @RequestHeader(value = "sSourceSystem", required = true) String sSourceSystem, @RequestHeader(value = "sProduct", required = true) String sProduct) {
        String emailUrl = "https://ssguat.serviceurl.in/hubx/send-mail";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", token);
        headers.set("sLoginId", sLoginId);
        headers.set("sPassword", sPassword);
        headers.set("sInstituteName", sInstituteName);
        headers.set("sApplicationId", sApplicationId);
        headers.set("sSourceSystem", sSourceSystem);
        headers.set("sProduct", sProduct);

        HttpEntity<EmailRequest> entityReq = new HttpEntity<EmailRequest>(request, headers);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> respEntity = template.exchange(emailUrl, HttpMethod.POST, entityReq, String.class);

        return respEntity;
    }

}
