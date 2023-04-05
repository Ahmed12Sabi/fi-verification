package ai.lentra.repository.applicationDetails;

import ai.lentra.modal.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDetails,Long> {
}
