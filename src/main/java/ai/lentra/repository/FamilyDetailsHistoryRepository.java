package ai.lentra.repository;

import ai.lentra.modal.famil_info.FamilyDetails;
import ai.lentra.modal.famil_info.FamilyDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyDetailsHistoryRepository extends JpaRepository<FamilyDetailsHistory,Long> {
}
