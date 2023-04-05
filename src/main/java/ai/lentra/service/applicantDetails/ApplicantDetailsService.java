package ai.lentra.service.applicantDetails;

import ai.lentra.dto.ApplicantDetailsDTO;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ApplicantDetailsService {
    public ResponseEntity<?> getApplicantDetails(Long applicantId) throws ResourceNotFoundException;
    public ResponseEntity<?> updateApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO);
    public ResponseEntity<?> saveApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO, HeadersDTO headers);
}
