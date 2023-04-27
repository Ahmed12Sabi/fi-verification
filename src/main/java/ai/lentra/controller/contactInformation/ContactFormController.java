package ai.lentra.controller.contactInformation;

import ai.lentra.dto.contactInfo.ContactDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.serviceImpl.contactInformation.ContactFormServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@Validated
@CrossOrigin(value = "http://localhost:8080")
@RequestMapping(value = "/contact-forms")
public class ContactFormController {

@Autowired
ContactFormServiceImpl contactFormServiceImpl;

    @PostMapping("/{applicantId}")
    public ResponseEntity<ResponseDTO> createContactForm(@RequestBody @Valid ContactDetailsDTO contactDetails, @PathVariable Long applicantId) throws ResourceNotFoundException, DuplicateResourceException {

    return contactFormServiceImpl.addContactForm(contactDetails,applicantId);
    }
    @GetMapping("/{applicantId}")
    public ResponseEntity<Object> getForm(@PathVariable Long applicantId) {
        return contactFormServiceImpl.getByApplicantId(applicantId);
    }
   @PatchMapping("/{applicantId}")
    public ResponseEntity<ResponseDTO> updateForm(@Valid @RequestBody ContactDetailsDTO contactDetails, @PathVariable Long applicantId)  {
        return contactFormServiceImpl.updateContactDetails(contactDetails,applicantId);
    }





}
