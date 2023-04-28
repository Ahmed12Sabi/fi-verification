package ai.lentra.repository.allocation;

import ai.lentra.modal.allocation.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationRepository extends JpaRepository<Verification,String> {

    Optional<Verification> findByAssignedToAndApplicantId(String assignedTo, long applicantId);

    Optional<Verification> findByAgencyNameAndApplicantId(String agencyName, long applicantId);

    Optional<List<Verification>> findAllByAssignedToAndVerificationStatusIgnoreCase(String userName, String status);

    Optional<List<Verification>> findAllByAssignedToIgnoreCase(String userName);

    Optional<Verification> findByFiId(String fiId);
}
