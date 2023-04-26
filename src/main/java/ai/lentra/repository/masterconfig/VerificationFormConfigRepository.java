package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationFormConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VerificationFormConfigRepository extends JpaRepository<VerificationFormConfig, Long> {

   @Query(value = "select v.form_id, v.v_id, v.form_name, v.form_description from verification_form_config v where v.v_id=?1", nativeQuery = true)
    List<VerificationFormConfig> getByVId(long l);

    List<VerificationFormConfig> getBySubProfileName(String subProfile);
}
