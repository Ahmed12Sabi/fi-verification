package ai.lentra.repository;

import ai.lentra.modal.famil_info.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails,Long> {
    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
