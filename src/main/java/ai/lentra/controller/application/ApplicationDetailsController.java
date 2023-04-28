package ai.lentra.controller.application;

import ai.lentra.commons.HeaderUtils;
import ai.lentra.controller.applicant.ApplicantDetailsController;
import ai.lentra.dto.headers.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.serviceImpl.application.ApplicationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ai.lentra.commons.FiIdGen.genFiId;

@RestController
@Validated
public class ApplicationDetailsController {

    private final Logger logger = LoggerFactory.getLogger(ApplicationDetailsController.class);
    @Autowired
    private ApplicationServiceImpl service;
    @PostMapping(value = "/application-details",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addApplication(@RequestBody @Valid Object application,
                                            @RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                            @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) throws JsonProcessingException {
        HeadersDTO headers = HeaderUtils.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        logger.info("Entered into addApplication");
        return service.addApplication(application, headers);
    }
    @GetMapping(value = "/application-details")
    public ResponseEntity<?> getApplication(
                                            @RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                            @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) throws ResourceNotFoundException {
        HeadersDTO headers = HeaderUtils.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        logger.info("Entered into getApplication");
        return service.getApplication(headers);
    }
    @PatchMapping(value = "/fi-id")
    public ResponseEntity<?> getFID() throws ResourceNotFoundException {
        logger.info("Entered into getFID");
      return   ResponseEntity.ok().body(genFiId());
    }


}
