package ai.lentra.service.verification;


import ai.lentra.dto.HeadersDTO;
import ai.lentra.dto.VerificationStatusDTO;
import ai.lentra.dto.VerifierDetailsDTO;
import ai.lentra.modal.VerificationStatus;
import ai.lentra.modal.VerifierDetails;
import ai.lentra.repository.VerifierDetailsRepository;
import ai.lentra.repository.verification.VerificationStatusRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

import static ai.lentra.config.dbConfig.ResponseConfig.responseGen;

@Service
public class VerificationStatusService {
    @Autowired
    VerificationStatusRepository verificationStatusRepository;
    @Autowired
    VerifierDetailsRepository verifierDetailsRepository;
    public ResponseEntity<?> updateVerificationStatus(VerificationStatusDTO verificationStatus, HeadersDTO headers) {
        ObjectMapper objectMapper = new ObjectMapper();
        VerificationStatus statusCopy= objectMapper.convertValue(verificationStatus,VerificationStatus.class);
        statusCopy.setApplicationType(headers.getApplicationType());
        statusCopy.setRoleType(headers.getRoleType());
        statusCopy.setInstitutionId(headers.getInstitutionId());
        statusCopy.setBranchName(headers.getBranchName());
        statusCopy.setUsername(headers.getUsername());
        statusCopy.setAssignedBy(verificationStatus.getAssignedBy());
        statusCopy.setInspectedBy(headers.getUsername());
        statusCopy.setInspectedDate(new Date());
        statusCopy.setAssignedTo(verificationStatus.getAssignedTo());
        VerificationStatus tempStatus= verificationStatusRepository.save(setApplication(statusCopy,headers));
        if(tempStatus!=null)
        {
            return ResponseEntity.ok().body(responseGen("Added successfully","Success","201"));
        }else{
            return ResponseEntity.badRequest().body(responseGen("Error While Adding","Failed","500"));
        }
    }
    public ResponseEntity<?> verifierStatus(VerifierDetailsDTO verifierDetailsDTO, HeadersDTO headers) {
        ObjectMapper objectMapper = new ObjectMapper();
        VerifierDetails verifierDetailsCopy= objectMapper.convertValue(verifierDetailsDTO, VerifierDetails.class);
        verifierDetailsCopy.setApplicationId(headers.getApplicationId());
        verifierDetailsCopy.setApplicationType(headers.getApplicationType());
        verifierDetailsCopy.setRoleType(headers.getRoleType());
        verifierDetailsCopy.setInstitutionId(headers.getInstitutionId());
        verifierDetailsCopy.setBranchName(headers.getBranchName());
        verifierDetailsCopy.setUsername(headers.getUsername());
        verifierDetailsCopy.setmAssignedBy(headers.getUsername());
        verifierDetailsCopy.setmInspectedDate(new Date());
        verifierDetailsCopy.setApplicationType(headers.getApplicationType());
        verifierDetailsCopy.setmAssignedTo(headers.getUsername());
        VerifierDetails tempVerifierDetails= verifierDetailsRepository.save(verifierDetailsCopy);
        if(tempVerifierDetails!=null)
        {
            return ResponseEntity.ok().body(responseGen("Added successfully","Success","201"));
        }else{
            return ResponseEntity.badRequest().body(responseGen("Error While Adding","Failed","500"));
        }
    }

    private VerificationStatus setApplication(VerificationStatus verificationStatus, HeadersDTO headers) {
        verificationStatus.setApplicationId(headers.getApplicationId());
        verificationStatus.setApplicationType(headers.getApplicationType());
        verificationStatus.setRoleType(headers.getRoleType());
        verificationStatus.setInstitutionId(headers.getInstitutionId());
        verificationStatus.setBranchName(headers.getBranchName());
        verificationStatus.setUsername(headers.getUsername());
        return verificationStatus;
    }


}
