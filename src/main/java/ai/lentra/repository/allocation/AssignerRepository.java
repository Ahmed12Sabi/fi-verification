package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.Assignor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignerRepository extends JpaRepository<Assignor,Long> {
    Optional<Assignor> findByFiId(String fiId);
}
