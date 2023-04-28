package ai.lentra.service.allocation;

import ai.lentra.dto.allocation.VerifierDetails;
import ai.lentra.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface AllocationService {


    public ResponseEntity<Object> fiAllocationBranch(VerifierDetails verifierDetails, boolean isSelf) throws ResourceNotFoundException;

    public ResponseEntity<Object> fiAllocationAgency(VerifierDetails verifierDetails, boolean isSelf) throws ResourceNotFoundException;

}
