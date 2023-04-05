package ai.lentra.dto.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDTO {
    private String Status;
    private String code;
    private String message;
    private Object data;

}
