package ai.lentra.repository.contactInformation;

import ai.lentra.modal.contact_info.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactFormRepository extends JpaRepository<ContactDetails, Long> {

    ContactDetails findByApplicantId(Long applicantId);

    @Query(value = "delete from contact_details a where a.modified_on  < now() - interval '2 month'", nativeQuery = true)
    void delete2MonthsData();
}
