package ai.lentra.commons;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class TokenAuth {
    RestTemplate    restTemplate= new RestTemplate();
    public String getToken(){
        String authUrl = "https://ssguat.serviceurl.in/uam-api/authenticate-client";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject reqBody = new JSONObject();
        reqBody.put("sClientIdentifier", "e93e1b22-8c39-3592-99f0-969378f75766");
        reqBody.put("sClientSecret", "f988b255-a792-31b8-972c-e6b996038014");
        reqBody.put("sInstitutionName", "SUPERSIXTY");
        reqBody.put("sApplication", "GoGetr");
        HttpEntity<String> entityReq = new HttpEntity<>(reqBody.toString(), headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> respEntity = template.exchange(authUrl, HttpMethod.POST, entityReq, String.class);
        JSONObject json = new JSONObject(respEntity.getBody());
        Object token = json.getJSONObject("oBody").getJSONObject("payLoad").getJSONObject("oauthToken").get("access_token");
        return "Bearer " +token;
    }
}
