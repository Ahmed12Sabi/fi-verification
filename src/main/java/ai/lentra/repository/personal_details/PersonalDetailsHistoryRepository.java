package ai.lentra.repository.personal_details;

import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.modal.personal_info.PersonalDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalDetailsHistoryRepository extends JpaRepository<PersonalDetailsHistory, Long> {
    Optional<PersonalDetails> findByApplicantId(long applicantId);

    boolean deleteByApplicantId(long i);
}
