package ai.lentra.repository.commitment;

import ai.lentra.modal.commitment.CommitmentDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitmentsHistoryRepository extends JpaRepository<CommitmentDetailsHistory,Long> {
}
