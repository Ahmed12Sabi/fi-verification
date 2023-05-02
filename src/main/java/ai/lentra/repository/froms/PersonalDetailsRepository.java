package ai.lentra.repository.froms;

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
    @Query(value = "DELETE FROM vms.personal_details WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
