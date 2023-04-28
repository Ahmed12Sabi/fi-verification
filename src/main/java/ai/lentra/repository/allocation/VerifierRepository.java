package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.Verifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifierRepository extends JpaRepository<Verifiers,String> {
    Optional<Verifiers> findByFiId(String fiId);
}
