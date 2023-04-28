package ai.lentra.controller.allocation;

import ai.lentra.dto.allocation.VerifierDetails;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.serviceImpl.allocation.AllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class VerificationAllocationController {
    @Autowired
    AllocationServiceImpl allocationServiceImpl;

    @PostMapping(value ="allocations/branches")
    public ResponseEntity<Object> getVerifierDetails(@RequestBody VerifierDetails verifierDetails, @RequestParam boolean isAgency,@RequestParam boolean isSelf,                                                  @RequestHeader(name = "tenant-id", required = true) String tenantId
                                                ) throws ResourceNotFoundException {
        if(isAgency){
            //agency allocation service call

            return allocationServiceImpl.fiAllocationAgency(verifierDetails,isSelf);
        }
        //branch allocation service call
        return allocationServiceImpl.fiAllocationBranch(verifierDetails,isSelf);
    }



}
