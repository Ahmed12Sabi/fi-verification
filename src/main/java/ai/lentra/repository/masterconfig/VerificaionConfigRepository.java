package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VerificaionConfigRepository extends JpaRepository<VerificationConfig, Long> {
    @Query(value="select r.v_id, r.v_type, r.v_description , r.m_id from verification_config r where r.m_id=?1", nativeQuery = true)
    List<VerificationConfig> findByMasterId(long id);
}
