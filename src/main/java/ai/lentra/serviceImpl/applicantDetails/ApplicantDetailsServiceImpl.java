package ai.lentra.serviceImpl.applicantDetails;

import ai.lentra.dto.ApplicantDetailsDTO;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.dto.VerificationStatusDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.ApplicantDetails;
import ai.lentra.modal.ApplicantDetailsHistory;
import ai.lentra.repository.applicantDetails.ApplicantDetailsHistoryRepository;
import ai.lentra.repository.applicantDetails.ApplicantDetailsRepository;
import ai.lentra.service.applicantDetails.ApplicantDetailsService;
import ai.lentra.service.verification.VerificationStatusService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService {
    @Autowired
    ApplicantDetailsHistoryRepository historyRepository;
    @Autowired
    ApplicantDetailsRepository applicantDetailsRepository;
    @Autowired
    VerificationStatusService verificationStatusService;
    @Override
    public ResponseEntity<?> getApplicantDetails(Long applicantId) throws ResourceNotFoundException {
        ApplicantDetails applicantDetails= applicantDetailsRepository.findByApplicantId(applicantId);
        if (applicantDetails==null) {
            throw new ResourceNotFoundException("Requested Applicant Details Not Found");
        }else {
            return new ResponseEntity<>(applicantDetails, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> updateApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> saveApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO, HeadersDTO headers) {
        ObjectMapper objectMapper= new ObjectMapper();
        if (applicantDetailsDTO.getVehicle()!=null)
        applicantDetailsDTO.getVehicle().setApplicantId(applicantId);
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
        ApplicantDetails applicantDetails = new ApplicantDetails();
        ApplicantDetailsHistory detailsHistory = new ApplicantDetailsHistory();
        applicantDetails=objectMapper.convertValue(applicantDetailsDTO,ApplicantDetails.class);
        detailsHistory=objectMapper.convertValue(applicantDetailsDTO,ApplicantDetailsHistory.class);
        detailsHistory.setApplicantId(applicantId);
        applicantDetails.setApplicantId(applicantId);

        ApplicantDetails tempDetails =applicantDetailsRepository.findByApplicantId(applicantId);
        if (tempDetails != null) {
            tempDetails.setPersonalDetails(applicantDetails.getPersonalDetails());
            tempDetails.setFamilyDetails(applicantDetails.getFamilyDetails());
            tempDetails.setOfficeSelfEmployment(applicantDetails.getOfficeSelfEmployment());
            tempDetails.setContactInformation(applicantDetails.getContactInformation());
            tempDetails.setExpenses(applicantDetails.getExpenses());
            tempDetails.setCommitments(applicantDetails.getCommitments());
            tempDetails.setResidences(applicantDetails.getResidences());
            tempDetails.setSummary(applicantDetails.getSummary());
            ApplicantDetailsHistory tempDetailsHistory = objectMapper.convertValue(tempDetails,ApplicantDetailsHistory.class);
            applicantDetailsRepository.save(tempDetails);
            historyRepository.save(tempDetailsHistory);
            VerificationStatusDTO statusDTO= new VerificationStatusDTO();
            statusDTO.setApplicationId(headers.getApplicationId());
            statusDTO.setStatus(applicantDetails.getStatus());
            statusDTO.setVerificationStage("COMPLETED");
            statusDTO.setBranchName(headers.getBranchName());
            statusDTO.setVerificationStatus(applicantDetails.getUserStatus());
            verificationStatusService.updateVerificationStatus(statusDTO,headers);
            return  new ResponseEntity<>(applicantDetails,HttpStatus.OK);

        }else {
            ApplicantDetails detailed = objectMapper.convertValue(detailsHistory, ApplicantDetails.class);
            applicantDetailsRepository.save(detailed);
            historyRepository.save(detailsHistory);
            return  new ResponseEntity<>(applicantDetails,HttpStatus.CREATED);
        }
    }
}
