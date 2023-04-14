package ai.lentra.repository.vehicleDetails;

import ai.lentra.modal.vehicle_info.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Long> {
    VehicleDetails findByApplicantId(Long applicantId);

    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
