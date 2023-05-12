package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationFormConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface VerificationFormConfigRepository extends JpaRepository<VerificationFormConfig, Long> {

//    @Query(value = "select v.form_id, v.v_id, v.form_name from schema_client1_vms.verification_form_config v where v.v_id=?1", nativeQuery = true)
//    List<VerificationFormConfig> getByVId(long mId);


List<VerificationFormConfig> findByVerificationConfig_vId(long vId);
}
