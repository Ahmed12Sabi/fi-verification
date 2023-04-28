package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.BranchDealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BranchDealeRepository extends JpaRepository<BranchDealer,Long> {
    Optional<List<BranchDealer>> findAllByLocationIgnoreCase(String location);

}
