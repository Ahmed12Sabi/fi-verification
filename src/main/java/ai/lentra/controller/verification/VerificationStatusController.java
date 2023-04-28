package ai.lentra.controller.verification;

import ai.lentra.controller.scheduler.FormCleanUpController;
import ai.lentra.dto.allocation.StatusUpdateDTO;
import ai.lentra.dto.allocation.VerificationDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.allocation.Agencies;
import ai.lentra.modal.allocation.BranchDealer;
import ai.lentra.serviceImpl.verification.VerificationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(VerificationStatusController.class);
    @Autowired
    VerificationServiceImpl verificationServiceImpl;

    @GetMapping(value = "/branches/{location}")
    public ResponseEntity<Object> getBranchesByPincode(@PathVariable String location) throws ResourceNotFoundException {
       logger.info("Entered into getBranchesByPincode");
        return verificationServiceImpl.getBranchesByLocation(location);
    }

    @PostMapping(value = "branches/locations")
    public List<BranchDealer> saveBranches(@RequestBody List<BranchDealer> branchDealers) {
        logger.info("Entered into saveBranches");
        return verificationServiceImpl.saveBranches(branchDealers);
    }

    @PostMapping(value = "agencies/locations")
    public List<Agencies> saveAgencies(@RequestBody List<Agencies> agencies) {
        logger.info("Entered into saveAgencies");
        return verificationServiceImpl.saveAgencies(agencies);
    }

    @GetMapping(value = "/branches")
    public ResponseEntity<Object> getNearByBranchDetails(@RequestHeader("application-id") long applicationId,
                                                    @RequestParam("location") String location, @RequestParam("applicant-id") long applicantId,
                                                    @RequestParam("address-type") String addressType,
                                                    @RequestParam("product-type") String productType) throws ResourceNotFoundException {
        logger.info("Entered into getNearByBranchDetails");
        return verificationServiceImpl.getNearByBranches(location, applicantId, addressType, applicationId, productType);
    }

    @GetMapping(value = "/agencies")
    public ResponseEntity<Object> getNearByAgencyDetails(@RequestHeader("application-id") long applicationId,
                                                    @RequestParam("branch-name") String branchName,
                                                    @RequestParam("applicant-id") long applicantId,
                                                    @RequestParam("address-type") String addressType,
                                                    @RequestParam("product-type") String productType) throws ResourceNotFoundException {
        logger.info("Entered into getNearByAgencyDetails");
        return verificationServiceImpl.getNearByAgencies(branchName, applicantId, addressType, applicationId, productType);
    }

    @GetMapping(value = "/branches/users/{branchName}")
    public ResponseEntity<Object> getUsersFromBranch(@PathVariable String branchName, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            logger.info("Entered into getUsersFromBranch");
            return verificationServiceImpl.getUsersFromAgency(branchName);
        }
        return null;
    }

    @GetMapping(value = "/branches/status/{status}/{userName}")
    public ResponseEntity<Object> getAllAllocationBasedOnStatus(@PathVariable String userName, @PathVariable String status, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            logger.info("Entered into getAllAllocationBasedOnStatus");
            return verificationServiceImpl.getUsersFromAgency(userName);
        }
        return verificationServiceImpl.getUsersAllocationNameAndStatus(userName, status);
    }

    @GetMapping(value = "/branches/{userName}")
    public ResponseEntity<Object> getAllAllocations(@PathVariable String userName, @PathVariable String status, @RequestParam("isAgency") boolean isAgency) throws ResourceNotFoundException {
        if (isAgency) {
            logger.info("Entered into getAllAllocationBasedOnStatus");
            return verificationServiceImpl.getUsersFromAgency(userName);
        }
        return verificationServiceImpl.getUsersAllocationName(userName);
    }

    @GetMapping(value = "/fi-status/{fiId}")
    public ResponseEntity<VerificationDTO> getVerifcationStatus(@PathVariable String fiId) throws ResourceNotFoundException {
        logger.info("Entered into getVerifcationStatus");
        return verificationServiceImpl.getVerificationBasedOnFiId(fiId);
    }

    @PutMapping(value = "/status/{status}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStatus(@PathVariable String status, @RequestBody StatusUpdateDTO statusUpdate) throws ResourceNotFoundException {
        logger.info("Entered into updateStatus");
        return verificationServiceImpl.statusUpdate(status, statusUpdate);
    }

    @PutMapping(value = "/verifications/cancel/{fiId}")
    public ResponseEntity<Object> cancelVerificationBy(@PathVariable String fiId) throws ResourceNotFoundException {
        logger.info("Entered into cancelVerificationBy");
        return verificationServiceImpl.cancelVerificationBy(fiId);
    }
}


