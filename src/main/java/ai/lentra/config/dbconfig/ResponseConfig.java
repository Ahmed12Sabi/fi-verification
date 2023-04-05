package ai.lentra.config.dbconfig;

import ai.lentra.dto.responses.ResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponseConfig {
    public static ResponseDTO responseGen(String message, String status, String code){
        ResponseDTO response = new ResponseDTO();
        response.setCode(code);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}
