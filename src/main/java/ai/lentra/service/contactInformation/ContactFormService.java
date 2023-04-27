package ai.lentra.service.contactInformation;

import ai.lentra.dto.contactInfo.ContactDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ContactFormService {
    public ResponseEntity<Object> getByApplicantId(Long applicantId);

    public ResponseEntity<ResponseDTO> addContactForm(ContactDetailsDTO contactDetailsD, Long applicantId) throws ResourceNotFoundException, DuplicateResourceException;
    public ResponseEntity<ResponseDTO> updateContactDetails(ContactDetailsDTO contactDetails, Long applicantId);
}