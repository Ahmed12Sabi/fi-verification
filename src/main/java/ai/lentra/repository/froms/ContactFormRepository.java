package ai.lentra.repository.froms;

import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.modal.scoreconfig.VerificationFormFieldsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactFormRepository extends JpaRepository<ContactDetails, Long> {

    ContactDetails findByApplicantId(Long applicantId);

    @Query(value = "DELETE FROM vms.contact_details WHERE modified_on < CURRENT_DATE - interval '2 month'",nativeQuery = true)
    public void delete2MonthsData();
}
