package ai.lentra.serviceImpl.applicant;

import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.applicant.ApplicantDetailsDTO;
import ai.lentra.dto.headers.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.repository.applicant.ApplicantDetailsRepository;
import ai.lentra.service.ApplicantDetailsService;
import ai.lentra.serviceImpl.allocation.AllocationServiceImpl;
import ai.lentra.serviceImpl.verification.VerificationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ai.lentra.commons.ResponseUtils.responseGen;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService {

    private final Logger logger = LoggerFactory.getLogger(ApplicantDetailsServiceImpl.class);
    @Autowired
    ApplicantDetailsRepository applicantDetailsRepository;
    @Autowired
    VerificationServiceImpl verificationServiceImpl;

    @Override
    public ResponseEntity<?> getApplicantDetails(Long applicantId) throws ResourceNotFoundException {
        ApplicantDetails applicantDetails= applicantDetailsRepository.findByApplicantId(applicantId).orElseThrow(()->new ResourceNotFoundException("Requested Applicant Details Not Found"));

            return new ResponseEntity<>(applicantDetails, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> updateApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO) {
        return null;
    }


    @Override
    public ResponseEntity<?> saveApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO, HeadersDTO headers) {
        applicantDetailsDTO.setApplicantId(applicantId);
        ObjectMapper objectMapper= new ObjectMapper();
        if (applicantDetailsDTO.getVehicleDetails()!=null)
            applicantDetailsDTO.getVehicleDetails().setApplicantId(applicantId);
        if (applicantDetailsDTO.getOfficeSelfEmployment()!=null)
            applicantDetailsDTO.getOfficeSelfEmployment().setApplicantId(applicantId);
        if (applicantDetailsDTO.getFamilyDetails()!=null)
            applicantDetailsDTO.getFamilyDetails().setApplicantId(applicantId);
        if (applicantDetailsDTO.getPersonalDetails()!=null)
            applicantDetailsDTO.getPersonalDetails().setApplicantId(applicantId);
        if (applicantDetailsDTO.getContactInformation()!=null)
            applicantDetailsDTO.getContactInformation().setApplicantId(applicantId);
        if (applicantDetailsDTO.getExpenses()!=null)
            applicantDetailsDTO.getExpenses().setApplicantId(applicantId);
        if (applicantDetailsDTO.getCommitments()!=null)
            applicantDetailsDTO.getCommitments().setApplicantId(applicantId);
        if (applicantDetailsDTO.getResidences()!=null)
            applicantDetailsDTO.getResidences().setApplicantId(applicantId);
        if (applicantDetailsDTO.getSummary()!=null)
            applicantDetailsDTO.getSummary().setApplicantId(applicantId);
        ApplicantDetails applicantDetails=objectMapper.convertValue(applicantDetailsDTO,ApplicantDetails.class);;

        applicantDetails.setApplicantId(applicantId);
        Optional<ApplicantDetails> optionalApplicant =applicantDetailsRepository.findByApplicantId(applicantId);

        if (optionalApplicant.isPresent()) {
            ApplicantDetails tempDetails= optionalApplicant.get();

            tempDetails.setPersonalDetails(applicantDetails.getPersonalDetails());
            tempDetails.setFamilyDetails(applicantDetails.getFamilyDetails());
            tempDetails.setOfficeSelfEmployment(applicantDetails.getOfficeSelfEmployment());
            tempDetails.setContactInformation(applicantDetails.getContactInformation());
            tempDetails.setExpenses(applicantDetails.getExpenses());
            tempDetails.setCommitments(applicantDetails.getCommitments());
            tempDetails.setResidences(applicantDetails.getResidences());
            tempDetails.setSummary(applicantDetails.getSummary());
            tempDetails.setVehicleDetails(applicantDetails.getVehicleDetails());
            applicantDetailsRepository.save(tempDetails);
//            historyRepository.save(tempDetailsHistory);
       /*     VerificationStatusDTO statusDTO= new VerificationStatusDTO();
            statusDTO = verificationStatusRepository.findByFiId("asdasd");
            statusDTO.setApplicationId(headers.getApplicationId());
            statusDTO.setStatus(applicantDetails.getStatus());
            statusDTO.setVerificationStage("COMPLETED");
            statusDTO.setBranchName(headers.getBranchName());
            statusDTO.setVerificationStatus(applicantDetails.getUserStatus());
            verificationServiceImpl.updateVerificationStatus(statusDTO,headers);*/
            logger.info("exit from saveApplicantDetails");
            return  ResponseEntity.ok().body(responseGen(I18nHelper.msg(I18nMessageKeys.applicant_details_updated),"Success","200"));
        }else {
            logger.info("Requested applicant information is not found in saveApplicantDetails");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGen(I18nHelper.msg(I18nMessageKeys.requested_applicant_not_found),"Resource Not Found","404"));
        }
    }
}
