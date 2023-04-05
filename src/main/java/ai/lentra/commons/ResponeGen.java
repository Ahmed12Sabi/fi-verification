package ai.lentra.commons;


import ai.lentra.dto.responses.ResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponeGen {

    public static ResponseDTO getSuccessResponse(int code , String message, String status,Object data) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setMessage(message);
        ResponseDTO.setCode(HttpStatus.valueOf(code).toString());
        ResponseDTO.setStatus(status);
        ResponseDTO.setData(data);

        return ResponseDTO;
    }
    public static ResponseDTO getResponse(int code , String message, String status) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setMessage(message);
        ResponseDTO.setCode(HttpStatus.valueOf(code).toString());
        ResponseDTO.setStatus(status);
//        ResponseDTO.setData(data);

        return ResponseDTO;
    }
}
