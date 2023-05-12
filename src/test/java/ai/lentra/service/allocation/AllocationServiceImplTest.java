package ai.lentra.service.allocation;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.allocation.AssignResponse;
import ai.lentra.dto.allocation.VerifierDetails;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.allocation.Assignor;
import ai.lentra.modal.allocation.Verification;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.repository.allocation.AssignerRepository;
import ai.lentra.repository.allocation.VerificationRepository;
import ai.lentra.repository.applicant.ApplicantDetailsRepository;
import ai.lentra.serviceImpl.allocation.AllocationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;


public class AllocationServiceImplTest extends TransactionalTestContainerSupport {

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private VerificationRepository verificationRepository;

    @Autowired
    private AssignerRepository assignerRepository;

    @Autowired
    private ApplicantDetailsRepository applicantDetailsRepository;
    @Autowired
    JsonUtils1 jsonUtils1;

    @Test
    public void testFiAllocationBranch() throws ResourceNotFoundException, JsonProcessingException {
        // create test data
        VerifierDetails verifierDetails = new VerifierDetails();
        verifierDetails.setAssignedTo("TL-001");
        verifierDetails.setAssignedBy("AGY-001");
        verifierDetails.setApplicantId(123123L);
        verifierDetails.setApplicantName("John Doe");
        verifierDetails.setCaseId("CASE-001");
        verifierDetails.setInstitutionId("INS-001");
        verifierDetails.setApplicationId(123123L);
        verifierDetails.setApplicantType("INDIVIDUAL");
        verifierDetails.setAssignedAgencyName("ABC Agency");
        verifierDetails.setAssignedAgencyCode("ABC001");
        verifierDetails.setAssignedBranchName("XYZ Branch");
        verifierDetails.setAssignedBranchCode("XYZ001");
        verifierDetails.setVerificationStatus("PENDING");
        verifierDetails.setVerificationStage("STAGE1");
        verifierDetails.setLoanAmount(50000L);
        verifierDetails.setApplicantAddress("123 Main St");
        verifierDetails.setApplicantPincode("12345");
        verifierDetails.setAddressType("PERMANENT");
        verifierDetails.setMobileNumber("555-123-4567");
        verifierDetails.setRemarks("Test Remarks");
        boolean isSelf = false;



        when(verificationRepository.findByAssignedToAndApplicantId("TL-001", 123123L)).thenReturn(Optional.of(jsonUtils1.mapper().readValue("  {\n" +
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

        Assignor assignorMock = new Assignor();
        when(assignerRepository.save(assignorMock)).thenReturn(assignorMock);

        ApplicantDetails applicantDetailsMock = new ApplicantDetails();
        when(applicantDetailsRepository.findByApplicantId(123123L)).thenReturn(Optional.of(applicantDetailsMock));


        ResponseEntity<Object> responseEntity = allocationService.fiAllocationBranch(verifierDetails, isSelf);


        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(verifierDetails.getAssignedBy(),((AssignResponse) responseEntity.getBody()).getAssignedBy());
        assertEquals(verifierDetails.getAssignedTo(),((AssignResponse) responseEntity.getBody()).getAssignedTo());

    }
    @Test
    public void testFiAllocationAgency() throws ResourceNotFoundException, JsonProcessingException {
        VerifierDetails verifierDetails = new VerifierDetails();
        verifierDetails.setAssignedTo("TL-001");
        verifierDetails.setAssignedBy("AGY-001");
        verifierDetails.setApplicantId(123123L);
        verifierDetails.setApplicantName("John Doe");
        verifierDetails.setCaseId("CASE-001");
        verifierDetails.setInstitutionId("INS-001");
        verifierDetails.setApplicationId(123123L);
        verifierDetails.setApplicantType("INDIVIDUAL");
        verifierDetails.setAssignedAgencyName("ABC Agency");
        verifierDetails.setAssignedAgencyCode("ABC001");
        verifierDetails.setAssignedBranchName("XYZ Branch");
        verifierDetails.setAssignedBranchCode("XYZ001");
        verifierDetails.setVerificationStatus("PENDING");
        verifierDetails.setVerificationStage("STAGE1");
        verifierDetails.setLoanAmount(50000L);
        verifierDetails.setApplicantAddress("123 Main St");
        verifierDetails.setApplicantPincode("12345");
        verifierDetails.setAddressType("PERMANENT");
        verifierDetails.setMobileNumber("555-123-4567");
        verifierDetails.setRemarks("Test Remarks");
        boolean isSelf = false;


        when(verificationRepository.findByAssignedToAndApplicantId("TL-001", 123123L)).thenReturn(Optional.of(jsonUtils1.mapper().readValue("  {\n" +
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

        Assignor assignorMock = new Assignor();
        when(assignerRepository.save(assignorMock)).thenReturn(assignorMock);

        ApplicantDetails applicantDetailsMock = new ApplicantDetails();
        when(applicantDetailsRepository.findByApplicantId(123123L)).thenReturn(Optional.of(applicantDetailsMock));


        // call the method to be tested
        ResponseEntity<Object> responseEntity = allocationService.fiAllocationAgency(verifierDetails, isSelf);

        // assert the result
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotEquals(verifierDetails.getAssignedBy(),((AssignResponse) responseEntity.getBody()).getAssignedTo());

        assertEquals(verifierDetails.getAssignedBy(),((AssignResponse) responseEntity.getBody()).getAssignedBy());
        assertEquals(verifierDetails.getAssignedTo(),((AssignResponse) responseEntity.getBody()).getAssignedTo());

    }

    //Test for self Allocation
    @Test
    public void testFiAllocationBranchSelf() throws ResourceNotFoundException, JsonProcessingException {
        // create test data
        VerifierDetails verifierDetails = new VerifierDetails();
        verifierDetails.setAssignedTo("TL-001");
        verifierDetails.setAssignedBy("AGY-001");
        verifierDetails.setApplicantId(123123L);
        verifierDetails.setApplicantName("John Doe");
        verifierDetails.setCaseId("CASE-001");
        verifierDetails.setInstitutionId("INS-001");
        verifierDetails.setApplicationId(123123L);
        verifierDetails.setApplicantType("INDIVIDUAL");
        verifierDetails.setAssignedAgencyName("ABC Agency");
        verifierDetails.setAssignedAgencyCode("ABC001");
        verifierDetails.setAssignedBranchName("XYZ Branch");
        verifierDetails.setAssignedBranchCode("XYZ001");
        verifierDetails.setVerificationStatus("PENDING");
        verifierDetails.setVerificationStage("STAGE1");
        verifierDetails.setLoanAmount(50000L);
        verifierDetails.setApplicantAddress("123 Main St");
        verifierDetails.setApplicantPincode("12345");
        verifierDetails.setAddressType("PERMANENT");
        verifierDetails.setMobileNumber("555-123-4567");
        verifierDetails.setRemarks("Test Remarks");
        boolean isSelf = true;


        when(verificationRepository.findByAssignedToAndApplicantId("TL-001", 123123L)).thenReturn(Optional.of(jsonUtils1.mapper().readValue("  {\n" +
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

        Assignor assignorMock = new Assignor();
        when(assignerRepository.save(assignorMock)).thenReturn(assignorMock);

        ApplicantDetails applicantDetailsMock = new ApplicantDetails();
        when(applicantDetailsRepository.findByApplicantId(123123L)).thenReturn(Optional.of(applicantDetailsMock));


        ResponseEntity<Object> responseEntity = allocationService.fiAllocationAgency(verifierDetails, isSelf);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(verifierDetails.getAssignedBy(),((AssignResponse) responseEntity.getBody()).getAssignedTo());

    }


}
