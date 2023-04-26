package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterVerificationConfigurationRepository extends JpaRepository<MasterVerificationConfiguration,Long> {

    /*@Query(value = "SELECT * FROM master_verification_configuration m WHERE m.profile_name=?1" , nativeQuery = true)
    List<MasterVerificationConfiguration> findByProfile(String profileName);*/

    @Query(value = "SELECT * FROM master_verification_configuration m WHERE m.institution_id=?1" , nativeQuery = true)

    List<MasterVerificationConfiguration> finByInstitutionId(Integer institutionId);
    List<MasterVerificationConfiguration> findByProfileName(String profileName);
    List<MasterVerificationConfiguration> findBySubProfileName(String subProfileName);
}
