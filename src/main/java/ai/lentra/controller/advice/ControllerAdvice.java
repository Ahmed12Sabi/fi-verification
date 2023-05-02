package ai.lentra.controller.advice;

import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.responses.ResponseDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.*;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.lentra.commons.ResponseUtils.responseGen;

@RestControllerAdvice
public class ControllerAdvice  {
//    to handle the file upload exceptions
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseDTO> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc) {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("400");
        responseDTO.setStatus("Upload Failed ");
        responseDTO.setMessage(I18nHelper.msg(I18nMessageKeys.file_size_exceed));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }
    //to handle the dto validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {


        List<ResponseDTO> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode("400");
        errorResponse.setStatus("Invalid Input Error");

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMapping.put(error.getField(), error.getDefaultMessage());
            errorResponse.setMessage(errorMapping.toString());
            responseDTOs.add(errorResponse);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTOs);
    }
    //to handle FileSizeLimitExceededException
    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<ResponseDTO> handleFileSizeLimitExceededException(FileSizeLimitExceededException exc) {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("400");
        responseDTO.setStatus("Upload Failed ");
        responseDTO.setMessage(I18nHelper.msg(I18nMessageKeys.file_size_exceed));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleLeadingZeroParseError(HttpMessageNotReadableException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("400");
        responseDTO.setStatus("Invalid Input");
        if(exc.getCause().toString().contains("Leading zeroes not allowed")){
            responseDTO.setMessage(I18nHelper.msg(I18nMessageKeys.contains_leading_zero));
        }
        if(exc.getCause().toString().contains("`java.math.BigDecimal` from String")){
            responseDTO.setMessage("Field contains Special Characters or Alphabets in number fields:");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }
//    To handle the ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("404");
        responseDTO.setStatus("ERROR");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateResource(DuplicateResourceException exc) {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("409");
        responseDTO.setStatus("Duplicate Request");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ResponseDTO> handleDateTimeParse(DateTimeParseException exc) {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("400");
        responseDTO.setStatus("Invalid Input");
        responseDTO.setMessage("Date should be in the format of  dd/mm/yyyy");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ResponseDTO> handleInvalidInput(InvalidInputException exc) {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("400");
        responseDTO.setStatus("Invalid Input");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<ResponseDto> handleCurrencyExceptions(CurrencyNotFoundException ex) {


        List<ResponseDto> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDto errorResponse= new ResponseDto();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ResidenceException.class)
    public ResponseEntity<ResponseDto> handleResidenceExceptions(CurrencyNotFoundException ex) {

        List<ResponseDto> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDto errorResponse= new ResponseDto();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseDTO> handleResidenceExceptions(MissingServletRequestParameterException ex) {



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseGen(ex.getLocalizedMessage(), "Invalid Request Parameters","400"));
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ResponseDTO> handleDateTimeParse(MissingRequestHeaderException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseGen(exc.getMessage(),"FAILED", "400"));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ResponseDTO> handleDateTimeParse(MissingPathVariableException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseGen(exc.getMessage(),"Invalid Request                         ", "400"));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ResponseDTO>> handleConstraintViolationException(ConstraintViolationException ex) {
        List<ResponseDTO> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode("400");
        errorResponse.setStatus("Invalid Input Error");

        ex.getConstraintViolations().forEach(error -> {
            errorMapping.put("Error", error.getMessage());
            errorResponse.setMessage(errorMapping.toString());
            responseDTOs.add(errorResponse);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTOs);
    }



}
