package ai.lentra.repository.froms;

import ai.lentra.modal.vehicle_info.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Long> {
    VehicleDetails findByApplicantId(Long applicantId);

    @Query(value = "DELETE FROM vms.vehicle_details WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
