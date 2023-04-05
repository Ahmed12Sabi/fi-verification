package ai.lentra.repository.applicationDetails;

import ai.lentra.modal.ApplicantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationCategoryRepository extends JpaRepository<ApplicantCategory,Long> {
    Optional<ApplicantCategory> findByApplicantIdAndApplicantCategory(Long applicantId, String category);
}
