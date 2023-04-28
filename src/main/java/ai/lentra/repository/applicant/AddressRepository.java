package ai.lentra.repository.applicant;

import ai.lentra.modal.applicant_details.ApplicantsAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<ApplicantsAddress,Long> {
}
