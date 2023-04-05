package ai.lentra.repository.officeDetails;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.modal.employment_info.OfficeSelfEmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeSelfEmploymentHistoryRepository extends JpaRepository<OfficeSelfEmploymentHistory, Long> {
}
