package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.VerificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VerificaionConfigRepository extends JpaRepository<VerificationConfig, Long> {


//    @Query(value="SELECT r.v_id, r.user_type,r.sub_profile_name, r.esign,r.retriger_verification, r.multi_verification_allowed, r.v_type, r.m_id\n" +
//            "\tFROM schema_client1_vms.verification_config r where r.m_id=?1", nativeQuery = true)
    List<VerificationConfig> findByMasterVerificationConfiguration_Id(long id);
//    List<VerificationConfig>  findByMasterVerificationConfiguration(long mId);
}
