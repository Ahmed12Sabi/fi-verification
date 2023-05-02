package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.OfflinePdfDataMapping;
import ai.lentra.modal.masterconfig.VerificationFormFieldMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfflinePdfDataRepository extends JpaRepository<OfflinePdfDataMapping, Long> {

}
