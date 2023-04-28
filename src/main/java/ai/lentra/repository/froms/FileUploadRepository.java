package ai.lentra.repository.froms;

import ai.lentra.modal.file_upload.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
    List<FileUpload> findByApplicantId(Long applicantId);
}
