package ai.lentra.repository.masterconfig;


import ai.lentra.modal.scoreconfig.VerificationFormFieldsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreConfigRepository extends JpaRepository<VerificationFormFieldsMaster,Long> {

    @Query(value = "select * from verification_form_fields_master m where m.is_scoring is true ",nativeQuery = true)
   public List<VerificationFormFieldsMaster> findscoringFields();
}
