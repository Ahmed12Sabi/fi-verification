package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.Verification;
import ai.lentra.modal.allocation.VerificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepositoryHistory extends JpaRepository<VerificationHistory,Long> {
}
