package ai.lentra.repository.verification;

import ai.lentra.modal.VerificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationStatusRepository extends JpaRepository<VerificationStatus,Long> {
}
