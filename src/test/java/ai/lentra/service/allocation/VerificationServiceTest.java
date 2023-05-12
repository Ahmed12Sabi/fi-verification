package ai.lentra.service.allocation;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.allocation.AssignResponse;
import ai.lentra.dto.allocation.VerifierDetails;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.allocation.Assignor;
import ai.lentra.modal.allocation.Verification;
import ai.lentra.repository.allocation.AssignerRepository;
import ai.lentra.repository.allocation.VerificationRepository;
import ai.lentra.serviceImpl.allocation.AllocationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class VerificationServiceTest extends TransactionalTestContainerSupport {

    @Autowired
    private AllocationServiceImpl allocationService;

    @Autowired
    private VerificationRepository verificationRepository;

    @Autowired
    private AssignerRepository assignerRepository;

    @Autowired
    JsonUtils1 jsonUtils1;

    @Test
    public void testFiAllocationAgency() throws ResourceNotFoundException, JsonProcessingException {
        // Mock Data for Verifiert Details
        VerifierDetails verifierDetails = new VerifierDetails();
        verifierDetails.setAgencyName("Agency A");
        verifierDetails.setApplicantId(123);
        verifierDetails.setApplicantName("John Doe");
        verifierDetails.setCaseId("Case1");
        verifierDetails.setInstitutionId("Institution1");
        verifierDetails.setApplicationId(456L);
        verifierDetails.setApplicantType("type1");
        verifierDetails.setAssignedBy("user1");
        verifierDetails.setAssignedTo("user2");
        verifierDetails.setAssignedAgencyName("Agency A");
        verifierDetails.setAssignedAgencyCode("A001");
        verifierDetails.setVerificationStatus("status1");
        verifierDetails.setVerificationStage("stage1");
        verifierDetails.setLoanAmount(10000L);
        verifierDetails.setApplicantAddress("Address1");
        verifierDetails.setApplicantPincode("123456");
        verifierDetails.setAddressType("type1");
        verifierDetails.setMobileNumber("1234567890");
        verifierDetails.setRemarks("remarks1");

        Verification verification = new Verification();
        verification.setFiId("F001");
        verification.setAssignedDateTime(Instant.now().toString());
        Assignor assignor = new Assignor();
        assignor.setFiId("F001");
        assignor.setAssignedDateTime(verification.getAssignedDateTime());

        when(verificationRepository.findByAgencyNameAndApplicantId(verifierDetails.getAgencyName(), verifierDetails.getApplicantId()))
                .thenReturn(Optional.of(jsonUtils1.mapper().readValue("  {\n" +
                        "        \"fiId\": \"ED729E59B56744F2B03079B1B677657C\",\n" +
                        "        \"applicantId\": 1234,\n" +
                        "        \"applicationId\": \"456\",\n" +
                        "        \"applicantName\": \"John Doe\",\n" +
                        "        \"address\": \"123 Main St, City, State, Country\",\n" +
                        "        \"addressType\": \"Residential\",\n" +
                        "        \"loanAmount\": 50000,\n" +
                        "        \"pincode\": \"123456\",\n" +
                        "        \"stage\": \"Stage 1\",\n" +
                        "        \"status\": \"Pending\"\n" +
                        "    }",Verification.class)));



        ResponseEntity<?> response = allocationService.fiAllocationAgency(verifierDetails, false);


        AssignResponse assignedResponse = new AssignResponse();
        assignedResponse.setAssignedDate(verification.getAssignedDateTime());
        assignedResponse.setAssignedTo(verification.getAssignedTo());
        assertEquals(ResponseEntity.ok().body(
              assignedResponse).getStatusCode(), response.getStatusCode());
    }
}
