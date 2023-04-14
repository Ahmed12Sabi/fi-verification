package ai.lentra.repository.commitment;


import ai.lentra.modal.commitment.CommitmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommitmentsRepository extends JpaRepository<CommitmentDetails,Long> {

    @Query(value = "delete from application_details a where a.created_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
