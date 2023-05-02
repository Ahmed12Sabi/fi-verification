package ai.lentra.repository.froms;

import ai.lentra.modal.commitment.CommitmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommitmentsRepository extends JpaRepository<CommitmentDetails,Long> {
    @Query(value = "DELETE FROM vms.contact_details WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
