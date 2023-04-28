package ai.lentra.controller.verification;

import ai.lentra.dto.allocation.StatusUpdateDTO;
import ai.lentra.dto.allocation.VerificationDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.allocation.Agencies;
import ai.lentra.modal.allocation.BranchDealer;
import ai.lentra.serviceImpl.verification.VerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Validated
@RequestMapping(value ="allocation")
public class VerificationStatusController {
    @Autowired
    VerificationServiceImpl verificationServiceImpl;

    @GetMapping(value = "/branches/{location}")
    public ResponseEntity<Object> getBranchesByPincode(@PathVariable String location) throws ResourceNotFoundException {
        return verificationServiceImpl.getBranchesByLocation(location);
    }

    @PostMapping(value = "branches/locations")
    public List<BranchDealer> saveBranches(@RequestBody List<BranchDealer> branchDealers) {

        return verificationServiceImpl.saveBranches(branchDealers);
    }

    @PostMapping(value = "agencies/locations")
    public List<Agencies> saveAgencies(@RequestBody List<Agencies> agencies) {
        return verificationServiceImpl.saveAgencies(agencies);
    }

    @GetMapping(value = "/branches")
    public ResponseEntity<Object> getNearByBranchDetails(@RequestHeader("application-id") long applicationId,
                                                    @RequestParam("location") String location, @RequestParam("applicant-id") long applicantId,
                                                    @RequestParam("address-type") String addressType,
                                                    @RequestParam("product-type") String productType) throws ResourceNotFoundException {
        return verificationServiceImpl.getNearByBranches(location, applicantId, addressType, applicationId, productType);
    }

    @GetMapping(value = "/agencies")
    public ResponseEntity<Object> getNearByAgencyDetails(@RequestHeader("application-id") long applicationId,
                                                    @RequestParam("branch-name") String branchName,
                                                    @RequestParam("applicant-id") long applicantId,
                                                    @RequestParam("address-type") String addressType,
                                                    @RequestParam("product-type") String productType) throws ResourceNotFoundException {
        return verificationServiceImpl.getNearByAgencies(branchName, applicantId, addressType, applicationId, productType);
    }

    @GetMapping(value = "/branches/users/{branchName}")
    public ResponseEntity<Object> getUsersFromBranch(@PathVariable String branchName, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            return verificationServiceImpl.getUsersFromAgency(branchName);
        }
        return null;
    }

    @GetMapping(value = "/branches/status/{status}/{userName}")
    public ResponseEntity<Object> getAllAllocationBasedOnStatus(@PathVariable String userName, @PathVariable String status, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            return verificationServiceImpl.getUsersFromAgency(userName);
        }
        return verificationServiceImpl.getUsersAllocationNameAndStatus(userName, status);
    }

    @GetMapping(value = "/branches/{userName}")
    public ResponseEntity<Object> getAllAllocations(@PathVariable String userName, @PathVariable String status, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            return verificationServiceImpl.getUsersFromAgency(userName);
        }
        return verificationServiceImpl.getUsersAllocationName(userName);
    }

    @GetMapping(value = "/fi-status/{fiId}")
    public ResponseEntity<VerificationDTO> getVerifcationStatus(@PathVariable String fiId) throws ResourceNotFoundException {

        return verificationServiceImpl.getVerificationBasedOnFiId(fiId);
    }

    @PutMapping(value = "/status/{status}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStatus(@PathVariable String status, @RequestBody StatusUpdateDTO statusUpdate) throws ResourceNotFoundException {
        return verificationServiceImpl.statusUpdate(status, statusUpdate);
    }

    @PutMapping(value = "/verifications/cancel/{fiId}")
    public ResponseEntity<Object> cancelVerificationBy(@PathVariable String fiId) throws ResourceNotFoundException {
        return verificationServiceImpl.cancelVerificationBy(fiId);
    }
}


