package ai.lentra.service.applicantDetails;

import ai.lentra.dto.ApplicationDetailsDTO;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.dto.VerificationStatusDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.ApplicantCategory;
import ai.lentra.modal.ApplicationDetails;
import ai.lentra.repository.applicationDetails.ApplicationCategoryRepository;
import ai.lentra.repository.applicationDetails.ApplicationRepository;
import ai.lentra.service.verification.VerificationStatusService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;

import static ai.lentra.config.dbConfig.ResponseConfig.responseGen;


@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicationCategoryRepository   applicationCategoryRepository;
@Autowired
VerificationStatusService verificationStatusService;

    public ResponseEntity<?> addApplication(ApplicationDetailsDTO application, HeadersDTO headers) {
        System.out.println(application);
        ApplicationDetails applicationDetails = setApplication(application);
        applicationDetails.setCreatedOn(Timestamp.from(Instant.now()));
        applicationDetails.setModifiedOn(Timestamp.from(Instant.now()));
        applicationDetails.setProductType(headers.getProductType());
        applicationDetails.setCreatedBy(headers.getUsername());
        applicationDetails.setModifiedBy(headers.getUsername());
        applicationDetails.setInsId(headers.getInstitutionId());

        applicationDetails.setApplicantDetails(application.getApplicantDetails().stream().map(details -> {
            details.setBranchName(headers.getBranchName());
          details.setStatus("Initiated");
            return details;
        }).collect(Collectors.toList()));
       ApplicationDetails tempApplicantDetails = applicationRepository.save(applicationDetails);
        if(tempApplicantDetails !=null)
        {
            VerificationStatusDTO statusDTO= new VerificationStatusDTO();
            statusDTO.setApplicationId(headers.getApplicationId());
            statusDTO.setStatus("Initiated");
            statusDTO.setVerificationStage("Initated");
            statusDTO.setBranchName(headers.getBranchName());
            statusDTO.setVerificationStatus("Initiated");
            verificationStatusService.updateVerificationStatus(statusDTO,headers);
            return ResponseEntity.ok().body(responseGen("Added successfully","Success","201"));
        }else{
            return ResponseEntity.badRequest().body(responseGen("Error While Adding","Failed","500"));
        }
    }

    ApplicationDetails setApplication(ApplicationDetailsDTO application1) {
        ObjectMapper objectMapper = new ObjectMapper();
        ApplicationDetails applicationDetails = objectMapper.convertValue(application1, ApplicationDetails.class);
        return applicationDetails;
    }
    public ResponseEntity<?> getByCategory(Long applicantId, String category) {
        ApplicantCategory category1;
        try {
            category1 = applicationCategoryRepository.findByApplicantIdAndApplicantCategory(applicantId, category).orElseThrow(()->new ResourceNotFoundException("Requested applicant is not present  "));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(responseGen("error", e.getMessage(), "404"));
        }
        return ResponseEntity.ok().body(category1);
    }
}
