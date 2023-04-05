package ai.lentra.controller.applicationDetails;

import ai.lentra.config.HeaderConfig;
import ai.lentra.dto.ApplicationDetailsDTO;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.modal.ApplicantCategory;
import ai.lentra.modal.ApplicationDetails;
import ai.lentra.service.applicantDetails.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ApplicationDetailsController {
    @Autowired
    private ApplicationService service;
    @PostMapping(value = "/application-details",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addApplication(@RequestBody @Valid ApplicationDetailsDTO application,
                                            @RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                            @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        HeadersDTO headers = HeaderConfig.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        return service.addApplication(application, headers);
    }
    @GetMapping(value = "/application-details")
    public ResponseEntity<?> getApplication(@RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                            @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        return ResponseEntity.ok().body(new ApplicationDetails());
    }
    @GetMapping(value = "/application-details/{applicantId}/applicant-categories/{applicantCategory}")
    public ResponseEntity<?> getByCategory(@PathVariable Long applicantId, @PathVariable String applicantCategory,
                                            @RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                            @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        return service.getByCategory(applicantId,applicantCategory);
    }
    @GetMapping(value = "/application-details/{applicantId}/applicant-categories/{applicantCategory}/test")
    public ResponseEntity<?> testGetByCategory(@PathVariable Long applicantId, @PathVariable String applicantCategory,
                                           @RequestHeader(name = "TOKEN", required = false) String token,
                                           @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                           @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                           @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                           @RequestHeader(name = "USER-NAME", required = true) String userName,
                                           @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                           @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                           @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        return  ResponseEntity.ok().body(new ApplicantCategory());
    }


}
