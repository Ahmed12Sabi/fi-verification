package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.Agencies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgenciesRepository extends JpaRepository<Agencies,Long> {
    Optional<List<Agencies>> findAllByBranchNameIgnoreCase(String upperCase);

    List<Agencies> findLabelByBranchNameIgnoreCase(String branchName);
}
