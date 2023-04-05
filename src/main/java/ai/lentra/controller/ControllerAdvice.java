//package ai.lentra.controller;
//
//
//import ai.lentra.dto.ResponseDTO;
//import ai.lentra.exceptions.DuplicateResourceException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingRequestHeaderException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static ai.lentra.config.ResponseConfig.responseGen;
//
//@RestControllerAdvice
//public class ControllerAdvice {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<ResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List<ResponseDTO> ResponseDTOs = new ArrayList<>();
//        Map<String, String> errorMapping = new HashMap<>();
//        ResponseDTO errorResponse= new ResponseDTO();
//        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
//        errorResponse.setStatus("Invalid Input Error");
//
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMapping.put(error.getField(), error.getDefaultMessage());
//            errorResponse.setMessage(errorMapping.toString());
//            ResponseDTOs.add(errorResponse);
//        });
//
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTOs);
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(DateTimeParseException.class)
//    public ResponseEntity<ResponseDTO> handleDateTimeParse(DateTimeParseException exc) {
//        ResponseDTO ResponseDTO = new ResponseDTO();
//        ResponseDTO.setCode(HttpStatus.BAD_REQUEST.toString());
//        ResponseDTO.setStatus("Invalid Input");
//        ResponseDTO.setMessage("Date should be in the format of  dd/mm/yyyy");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO);
//    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MissingRequestHeaderException.class)
//    public ResponseEntity<ResponseDTO> handleDateTimeParse(MissingRequestHeaderException exc) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseGen(exc.getMessage(),"FAILED", "400"));
//    }
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler(DuplicateResourceException.class)
//    public ResponseEntity<ResponseDTO> handleDuplicateResource(DuplicateResourceException exc) {
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setCode("409");
//        responseDTO.setStatus("Duplicate Request");
//        responseDTO.setMessage(exc.getMessage());
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
//    }
//
//
//
//}
