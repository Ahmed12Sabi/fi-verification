package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.VerifierHistory;
import ai.lentra.modal.allocation.Verifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifierRepositoryHistory extends JpaRepository<VerifierHistory,String> {
    Optional<Verifiers> findByFiId(String fiId);
}
