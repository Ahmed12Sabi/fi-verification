package ai.lentra.repository.allocation;

import ai.lentra.modal.application.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDetails,Long> {
   Optional<ApplicationDetails> findByApplicationIdAndProductType(Long applicationId, String productType);

   ApplicationDetails getByInsIdAndProductType(String instituteId,String product);
}
