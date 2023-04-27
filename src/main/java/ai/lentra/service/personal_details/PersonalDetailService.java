package ai.lentra.service.personal_details;

import ai.lentra.dto.personalInfo.PersonalDetailsDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface PersonalDetailService {
    public ResponseEntity<?> addPersonalDetail(PersonalDetailsDTO personalDetailsDTO, Long applicantId) throws DuplicateResourceException, InvalidInputException;

    ResponseEntity<PersonalDetailsDTO> getPersonalDetailByApplicantId(Long applicantId) throws ResourceNotFoundException;


    ResponseEntity<?> updatePersonalDetail(PersonalDetailsDTO details, Long applicantId) throws ResourceNotFoundException, InvalidInputException;

}
