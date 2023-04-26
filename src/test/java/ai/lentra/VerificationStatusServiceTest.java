///*
//package ai.lentra;
//
//import ai.lentra.dto.HeadersDTO;
//import ai.lentra.dto.VerificationStatusDTO;
//import ai.lentra.dto.VerifierDetailsDTO;
//import ai.lentra.dto.responses.ResponseDTO;
//import ai.lentra.modal.VerificationStatus;
//import ai.lentra.modal.VerifierDetails;
//import ai.lentra.repository.VerifierDetailsRepository;
//import ai.lentra.repository.verification.VerificationStatusRepository;
//import ai.lentra.service.verification.VerificationStatusService;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class VerificationStatusServiceTest {
//
//    @Mock
//    VerificationStatusRepository verificationStatusRepository;
//
//    @Mock
//    VerifierDetailsRepository verifierDetailsRepository;
//
//    @InjectMocks
//    VerificationStatusService verificationStatusService;
//
//    @Test
//    public void testUpdateVerificationStatus() {
//        VerificationStatusDTO verificationStatus = new VerificationStatusDTO();
//        verificationStatus.setAssignedBy("John");
//        verificationStatus.setAssignedTo("Jane");
//
//        HeadersDTO headers = new HeadersDTO();
//        headers.setApplicationId(1L);
//        headers.setApplicationType("Type A");
//        headers.setRoleType("Role B");
//        headers.setInstitutionId("Institution C");
//        headers.setBranchName("Branch D");
//        headers.setUsername("User E");
//
//        VerificationStatus statusCopy = new VerificationStatus();
//        statusCopy.setAssignedBy("John");
//        statusCopy.setAssignedTo("Jane");
//        statusCopy.setApplicationType("Type A");
//        statusCopy.setRoleType("Role B");
//        statusCopy.setInstitutionId("Institution C");
//        statusCopy.setBranchName("Branch D");
//        statusCopy.setUsername("User E");
//        statusCopy.setInspectedBy("User E");
//        statusCopy.setInspectedDate(new Date());
//
//        when(verificationStatusRepository.save(Mockito.any(VerificationStatus.class))).thenReturn(statusCopy);
//
//        ResponseEntity<?> responseEntity = verificationStatusService.updateVerificationStatus(verificationStatus, headers);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Added successfully", ((ResponseDTO)responseEntity.getBody()).getMessage());
//        assertEquals("Success", ((ResponseDTO)responseEntity.getBody()).getStatus());
//        assertEquals("201", ((ResponseDTO)responseEntity.getBody()).getCode());
//    }
//
//    @Test
//    public void testVerifierStatus() {
//        VerifierDetailsDTO verifierDetailsDTO = new VerifierDetailsDTO();
//        verifierDetailsDTO.setApplicationId(1L);
//        verifierDetailsDTO.setApplicationType("Type A");
//        verifierDetailsDTO.setRoleType("Role B");
//        verifierDetailsDTO.setInstitutionId("Institution C");
//        verifierDetailsDTO.setBranchName("Branch D");
//        HeadersDTO headers = new HeadersDTO();
//        headers.setApplicationId(1L);
//        headers.setApplicationType("Type A");
//        headers.setRoleType("Role B");
//        headers.setInstitutionId("Institution C");
//        headers.setBranchName("Branch D");
//        headers.setUsername("User E");
//        VerifierDetails verifierDetailsCopy = new VerifierDetails();
//        verifierDetailsCopy.setApplicationId(1L);
//        verifierDetailsCopy.setApplicationType("Type A");
//        verifierDetailsCopy.setRoleType("Role B");
//        verifierDetailsCopy.setInstitutionId("Institution C");
//        verifierDetailsCopy.setBranchName("Branch D");
//        verifierDetailsCopy.setUsername("User E");
//        verifierDetailsCopy("User E");
//        verifierDetailsCopy.setMInspectedDate(new Date());
//        verifierDetailsCopy.setMAssignedTo("User E");
//
//        when(verifierDetailsRepository.save(Mockito.any(VerifierDetails.class))).thenReturn(verifierDetailsCopy);
//
//        ResponseEntity<?> responseEntity = verificationStatusService.verifierStatus(verifierDetailsDTO, headers);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Added successfully", ((ResponseDTO)responseEntity.getBody()).getMessage());
//        assertEquals("Success", ((ResponseDTO)responseEntity.getBody()).getStatus());
//        assertEquals("201", ((ResponseDTO)responseEntity.getBody()).getCode());
//    }
//
//}
//*/
