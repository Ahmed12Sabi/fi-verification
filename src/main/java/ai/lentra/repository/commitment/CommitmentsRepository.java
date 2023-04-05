package ai.lentra.repository.commitment;


import ai.lentra.modal.commitment.CommitmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitmentsRepository extends JpaRepository<CommitmentDetails,Long> {
}
