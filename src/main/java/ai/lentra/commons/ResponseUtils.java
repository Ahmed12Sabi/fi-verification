package ai.lentra.commons;

import ai.lentra.dto.responses.ResponseDTO;

public class ResponseUtils {
    public static ResponseDTO responseGen(String message, String status, String code){
        ResponseDTO response = new ResponseDTO();
        response.setCode(code);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}
