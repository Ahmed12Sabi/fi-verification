package ai.lentra.repository.contactInformation;

import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.modal.contact_info.ContactDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactFormHistoryRepository extends JpaRepository<ContactDetailsHistory, Long> {

    ContactDetails findByApplicantId(Long applicantId);
}
