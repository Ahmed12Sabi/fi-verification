package ai.lentra.repository.applicant;

import ai.lentra.modal.applicant_details.ApplicantDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails,Long> {
    Optional<ApplicantDetails> findByApplicantId(Long applicantId);
}
