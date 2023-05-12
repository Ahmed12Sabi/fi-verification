package ai.lentra.service;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.repository.froms.FileUploadRepository;
import ai.lentra.serviceImpl.FileUploadServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileUploadServiceImplTest {

    @InjectMocks
    private FileUploadServiceImpl fileUploadService;

    @Mock
    private FileUploadRepository fileUploadRepository;

    @Test
    public void testUploadFilesOnline_Success() throws IOException {

        Long applicantId = 123L;
        MultipartFile[] files = new MultipartFile[1];
        MockMultipartFile mockFile = new MockMultipartFile("test.pdf", "test.pdf", "application/pdf", "test data".getBytes());
        files[0] = mockFile;
        String latitude = "1.234";
        String longitude = "5.678";


        ResponseEntity<?> responseEntity = fileUploadService.uploadFilesOnline(applicantId, files, latitude, longitude);

        verify(fileUploadRepository, times(1)).saveAll(anyList());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("All files uploaded successfully along with the geoTag latitude: " + latitude + " longitude: " + longitude, responseEntity.getBody());
    }

    @Test
    public void testUploadFilesOnline_Failure() throws IOException {
       //mocking
        Long applicantId = 123L;
        MultipartFile[] files = new MultipartFile[1];
        MockMultipartFile mockFile = new MockMultipartFile("test.exe", "test.exe", "application/octet-stream", "test data".getBytes());
        files[0] = mockFile;
        String latitude = null;
        String longitude = "5.678";

    //exec method
        ResponseEntity<?> responseEntity = fileUploadService.uploadFilesOnline(applicantId, files, latitude, longitude);
        //verifyiung
        verify(fileUploadRepository, never()).saveAll(anyList());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof List);
        List<ResponseDTO> errorList = (List<ResponseDTO>) responseEntity.getBody();
        assertEquals(2, errorList.size());
        assertEquals("400", errorList.get(0).getCode());
        assertTrue(errorList.get(0).getMessage().contains("Only Documents allowed"));
        assertEquals("400", errorList.get(1).getCode());
        assertTrue(errorList.get(1).getMessage().contains("Location must be a valid latitude and longitude"));
    }
    @Test
    public void testUploadFilesOffline_Success() throws IOException {

        Long applicantId = 123L;
        MultipartFile[] files = new MultipartFile[1];
        MockMultipartFile mockFile = new MockMultipartFile("test.pdf", "test.pdf", "application/pdf", "test data".getBytes());
        files[0] = mockFile;
        String latitude = "1.234";
        String longitude = "5.678";


        ResponseEntity<?> responseEntity = fileUploadService.uploadFilesOffline(applicantId, files);

        verify(fileUploadRepository, times(1)).saveAll(anyList());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("All files uploaded successfully", responseEntity.getBody().toString().trim());
    }
}
