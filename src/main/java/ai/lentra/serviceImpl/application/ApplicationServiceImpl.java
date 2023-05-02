package ai.lentra.serviceImpl.application;

import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.application.ApplicationDetailsDTO;
import ai.lentra.dto.headers.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.application.ApplicationDetails;
import ai.lentra.modal.application.ApplicationRawObject;
import ai.lentra.repository.allocation.ApplicationRawDataRepository;
import ai.lentra.repository.allocation.ApplicationRepository;
import ai.lentra.serviceImpl.applicant.ApplicantDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;

import static ai.lentra.commons.ResponseUtils.responseGen;


@Service
public class ApplicationServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicationRawDataRepository rawRepository;
    public ResponseEntity<?> addApplication(Object application1, HeadersDTO headers)  {
        ObjectMapper mapper = new ObjectMapper();
        ApplicationRawObject rawObject = new ApplicationRawObject();
        Object jsonObject = application1;
        ApplicationDetailsDTO application = mapper.convertValue(application1, ApplicationDetailsDTO.class);
        rawObject.setRawData(jsonObject);
        rawObject.setCaseId(String.valueOf(application.getCaseId()));
        rawObject.setCreatedOn(Timestamp.from(Instant.now()));
        rawObject.setApplicationId(headers.getApplicationId());
        rawRepository.save(rawObject);
        application.setVerificationStage("VERIFICATION");
        application.setVerificationStatus("VERIFICATION INITIATED");
        ApplicationDetails applicationDetails = setApplication(application);
        applicationDetails.setCreatedOn(Timestamp.from(Instant.now()));
        applicationDetails.setModifiedOn(Timestamp.from(Instant.now()));
        applicationDetails.setProductType(headers.getProductType());
        applicationDetails.setCreatedBy(headers.getUsername());
        applicationDetails.setModifiedBy(headers.getUsername());
        applicationDetails.setInsId(headers.getInstitutionId());
        applicationDetails.setApplicantDetails(application.getApplicantDetails().stream().map(details -> {
            details.setBranchName(headers.getBranchName());
            details.setCaseId(application.getCaseId());
            details.setStatus("Initiated");
            return details;
        }).collect(Collectors.toList()));
        applicationDetails.setApplicationId(headers.getApplicationId());
        applicationDetails.getApplicantDetails().stream().map(details -> {
            if (details.getFamilyDetails() != null)
                details.getFamilyDetails().setApplicantId(details.getApplicantId());
            if (details.getPersonalDetails() != null)
                details.getPersonalDetails().setApplicantId(details.getApplicantId());
            if (details.getCommitments() != null)
                details.getCommitments().setApplicantId(details.getApplicantId());
            if (details.getExpenses() != null)
                details.getExpenses().setApplicantId(details.getApplicantId());
            if (details.getVehicleDetails() != null)
                details.getVehicleDetails().setApplicantId(details.getApplicantId());
            if (details.getSummary() != null)
                details.getSummary().setApplicantId(details.getApplicantId());
            if (details.getOfficeSelfEmployment() != null)
                details.getOfficeSelfEmployment().setApplicantId(details.getApplicantId());
            if (details.getResidences() != null)
                details.getResidences().setApplicantId(details.getApplicantId());
            if (details.getContactInformation() != null)
                details.getContactInformation().setApplicantId(details.getApplicantId());
            return details;
        }).collect(Collectors.toList());


        ApplicationDetails tempApplicantDetails=new ApplicationDetails();
        try {
            tempApplicantDetails = applicationRepository.save(applicationDetails);
        } catch (Exception e) {
            logger.info("addApplication :"+e.getMessage());
            return ResponseEntity.internalServerError().body((responseGen(I18nHelper.msg(I18nMessageKeys.error_while_adding), "Failed", "500")));

        }
        logger.info("Successfully Application Added");
        return ResponseEntity.status(HttpStatus.CREATED).body(tempApplicantDetails);

    }

    ApplicationDetails setApplication(ApplicationDetailsDTO application1) {
        ObjectMapper objectMapper = new ObjectMapper();
        ApplicationDetails applicationDetails = objectMapper.convertValue(application1, ApplicationDetails.class);
        logger.info("Exit setApplication");
        return applicationDetails;
    }

    public ResponseEntity<?> getApplication(HeadersDTO headers) throws ResourceNotFoundException {
        logger.info("Entered in ServiceImpl getApplication");
        return ResponseEntity.ok().body(applicationRepository.findByApplicationIdAndProductType(headers.getApplicationId(), headers.getProductType()).orElseThrow(()->  new  ResourceNotFoundException("Requested application does not exist for application id :" + headers.getApplicationId() +" and application type :"+ headers.getApplicantType())));
    }
}
