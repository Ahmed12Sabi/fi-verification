package ai.lentra.repository.verification;

import ai.lentra.modal.allocation.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationStatusRepository extends JpaRepository<Verification,Long> {
}
