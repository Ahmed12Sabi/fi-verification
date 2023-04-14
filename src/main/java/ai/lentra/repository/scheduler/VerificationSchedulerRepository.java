package ai.lentra.repository.scheduler;

import ai.lentra.modal.residence.ResidenceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VerificationSchedulerRepository  extends JpaRepository<ResidenceDetails,Long> {
    @Query(value = "delete from ",nativeQuery = true)
    int deleteBeforeTwoMonthData(Long residenceId);
}
