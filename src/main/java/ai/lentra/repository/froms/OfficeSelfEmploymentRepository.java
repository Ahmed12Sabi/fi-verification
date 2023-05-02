package ai.lentra.repository.froms;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfficeSelfEmploymentRepository extends JpaRepository<OfficeSelfEmployment, Long> {
    @Query(value = "DELETE FROM vms.office_self_employment WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
