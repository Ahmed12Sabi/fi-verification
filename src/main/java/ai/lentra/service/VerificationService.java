package ai.lentra.service;


import ai.lentra.dto.allocation.StatusUpdateDTO;
import ai.lentra.dto.allocation.VerificationDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.allocation.Agencies;
import ai.lentra.modal.allocation.BranchDealer;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface VerificationService {



    ResponseEntity<Object> getBranchesByLocation(String location) throws ResourceNotFoundException;

    List<BranchDealer> saveBranches(List<BranchDealer> branches);

    List<Agencies> saveAgencies(List<Agencies> agencies);

    ResponseEntity<Object> getNearByBranches(String location, Long applicantId, String addressType, long applicationId, String productType) throws ResourceNotFoundException;

    ResponseEntity<Object> getNearByAgencies(String branchName, long applicantId, String addressType, long applicationId, String productType) throws ResourceNotFoundException;

    ResponseEntity<Object> getUsersFromAgency(String branchName);

    ResponseEntity<Object> getUsersAllocationNameAndStatus(String userName, String status) throws ResourceNotFoundException;

    ResponseEntity<Object> getUsersAllocationName(String userName) throws ResourceNotFoundException;

    ResponseEntity<VerificationDTO> getVerificationBasedOnFiId(String fiId) throws ResourceNotFoundException;

    ResponseEntity<Object> statusUpdate(String status, StatusUpdateDTO statusUpdate) throws ResourceNotFoundException;

    ResponseEntity<Object> cancelVerificationBy(String fiId) throws ResourceNotFoundException;
}
