package ai.lentra.controller.applicantDetails;

import ai.lentra.config.HeaderConfig;
import ai.lentra.dto.ApplicantDetailsDTO;
import ai.lentra.dto.ApplicationDetailsDTO;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.ApplicationDetails;
import ai.lentra.service.applicantDetails.ApplicantDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ApplicantDetailsController {

    @Autowired
    private ApplicantDetailsService applicantDetailsService;
    @PostMapping("/applicants/applicant-forms-details/{applicantId}")
    public ResponseEntity<?> saveApplicantDetails(@RequestBody @Valid ApplicationDetailsDTO application,
                                                  @RequestHeader(name = "TOKEN", required = false) String token,
                                                  @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                                  @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                                  @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                                  @RequestHeader(name = "USER-NAME", required = true) String userName,
                                                  @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                                  @RequestHeader(name = "BRANCH-NAME", required = false) String branchName,
                                                  @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType,
            @PathVariable("applicantId") long applicantId, @RequestBody ApplicantDetailsDTO applicantDetailsDTO) {
        applicantDetailsDTO.setApplicantId(applicantId);
        HeadersDTO headers = HeaderConfig.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType,applicantType);
        return applicantDetailsService.saveApplicantDetails(applicantId, applicantDetailsDTO,headers);
    }
    @GetMapping("/applicants/applicant-forms-details/{applicantId}")
    public ResponseEntity<?> getApplicantDetails(@PathVariable("applicantId") long applicantId) throws ResourceNotFoundException {
        return applicantDetailsService.getApplicantDetails(applicantId);
    }

    @PatchMapping("/applicants/{applicantId}")
    public ResponseEntity<?> updateApplicantDetails(@PathVariable("applicantId") long applicantId) {
        return null;
    }
}


