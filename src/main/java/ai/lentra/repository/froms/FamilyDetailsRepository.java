package ai.lentra.repository.froms;

import ai.lentra.modal.famil_info.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails,Long> {
    @Query(value = "DELETE FROM vms.family_details WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
