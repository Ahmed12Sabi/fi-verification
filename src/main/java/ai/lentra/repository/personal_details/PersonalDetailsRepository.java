package ai.lentra.repository.personal_details;

import ai.lentra.modal.personal_info.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    Optional<PersonalDetails> findByApplicantId(long applicantId);

    boolean deleteByApplicantId(long i);

    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
