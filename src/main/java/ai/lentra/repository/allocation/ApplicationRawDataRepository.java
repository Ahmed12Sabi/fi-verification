package ai.lentra.repository.allocation;

import ai.lentra.modal.application.ApplicationRawObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRawDataRepository extends JpaRepository<ApplicationRawObject,String> {
}
