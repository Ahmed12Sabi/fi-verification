package ai.lentra.repository.officeDetails;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfficeSelfEmploymentRepository extends JpaRepository<OfficeSelfEmployment, Long> {

    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
