package ai.lentra.repository.applicantDetails;

import ai.lentra.modal.ApplicantDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDetailsHistoryRepository extends JpaRepository<ApplicantDetailsHistory,Long> {
}
