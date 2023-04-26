package ai.lentra.modal.responses;


import org.springframework.http.HttpStatus;


public class ResponseDTO {
    private String Status;
    private HttpStatus code;
    private String message;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
