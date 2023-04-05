package ai.lentra.repository.applicantDetails;

import ai.lentra.modal.ApplicantDetails;
import ai.lentra.modal.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails,Long> {
    ApplicantDetails findByApplicantId(Long applicantId);
}
