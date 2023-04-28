//package ai.lentra;
//
//import ai.lentra.dto.responses.ResponseDTO;
//import ai.lentra.repository.allocation.ApplicationRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ApplicationServiceTest {
//
//    @InjectMocks
//    private ApplicationService applicationService;
//
//    @Mock
//    private ApplicationRepository applicationRepository;
//
//    @Mock
//    private Applicatio applicationCategoryRepository;
//
//    @Test
//    public void testAddApplication() {
//
//        ApplicationDetailsDTO application = new ApplicationDetailsDTO();
//        HeadersDTO headers = new HeadersDTO();
//        ApplicationDetails expectedApplicationDetails = new ApplicationDetails();
//        expectedApplicationDetails.setId(1L);
//
//        Mockito.when(applicationRepository.save(Mockito.any(ApplicationDetails.class))).thenReturn(expectedApplicationDetails);
//
//        ResponseEntity<?> response = applicationService.addApplication(application, headers);
//
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Added successfully", ((ResponseDTO) response.getBody()).getMessage());
//        assertEquals("Success", ((ResponseDTO) response.getBody()).getStatus());
//        assertEquals("201", ((ResponseDTO) response.getBody()).getCode());
//    }
//
//    @Test
//    public void testGetByCategory() {
//
//        Long applicantId = 1L;
//        String category = "category";
//        ApplicantCategory expectedApplicantCategory = new ApplicantCategory();
//        expectedApplicantCategory.setId(1L);
//
//        Mockito.when(applicationCategoryRepository.findByApplicantIdAndApplicantCategory(Mockito.anyLong(), Mockito.anyString())).thenReturn(Optional.of(expectedApplicantCategory));
//
//        ResponseEntity<?> response = applicationService.getByCategory(applicantId, category);
//
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(expectedApplicantCategory, response.getBody());
//    }
//
//    @Test
//    public void testGetByCategoryNotFound() {
//
//        Long applicantId = 1L;
//        String category = "category";
//
//        Mockito.when(applicationCategoryRepository.findByApplicantIdAndApplicantCategory(Mockito.anyLong(), Mockito.anyString())).thenReturn(Optional.empty());
//
//        ResponseEntity<?> response = applicationService.getByCategory(applicantId, category);
//
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Requested applicant is not present", ((ResponseDTO) response.getBody()).getMessage());
//        assertEquals("404", ((ResponseDTO) response.getBody()).getCode());
//    }
//}
