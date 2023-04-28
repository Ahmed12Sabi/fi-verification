package ai.lentra.controller.applicant;

import ai.lentra.commons.HeaderUtils;
import ai.lentra.controller.configuration.roles.RoleConfigController;
import ai.lentra.dto.applicant.ApplicantDetailsDTO;
import ai.lentra.dto.headers.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.service.ApplicantDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ApplicantDetailsController {

    private final Logger logger = LoggerFactory.getLogger(ApplicantDetailsController.class);
    @Autowired
    private ApplicantDetailsService applicantDetailsService;
    @PutMapping("/applicants/applicant-forms-details/{applicantId}")
    public ResponseEntity<?> saveApplicantDetails( @RequestHeader(name = "TOKEN", required = false) String token,
                                                  @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                                  @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                                  @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                                  @RequestHeader(name = "USER-NAME", required = true) String userName,
                                                  @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                                  @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                                  @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType,
            @PathVariable long applicantId,@Valid @RequestBody ApplicantDetailsDTO applicantDetailsDTO) {
        HeadersDTO headers = HeaderUtils.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType,applicantType);
        logger.info("Entered into saveApplicantDetails : ");
        return applicantDetailsService.saveApplicantDetails(applicantId, applicantDetailsDTO,headers);
    }
    @GetMapping("/applicants/applicant-forms-details/{applicantId}")
    public ResponseEntity<?> getApplicantDetails(@PathVariable("applicantId") long applicantId) throws ResourceNotFoundException {
        logger.info("Entered into getApplicantDetails : ");
        return applicantDetailsService.getApplicantDetails(applicantId);
    }
    @PatchMapping("/applicants/{applicantId}")
    public ResponseEntity<?> updateApplicantDetails(@PathVariable("applicantId") long applicantId) {
        logger.info("Entered into updateApplicantDetails : ");
        return ResponseEntity.ok().body(new ApplicantDetails());
    }
}


