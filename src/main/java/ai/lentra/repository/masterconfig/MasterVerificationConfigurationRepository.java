package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MasterVerificationConfigurationRepository extends JpaRepository<MasterVerificationConfiguration,Long> {

    /*@Query(value = "SELECT * FROM master_verification_configuration m WHERE m.profile_name=?1" , nativeQuery = true)
    List<MasterVerificationConfiguration> findByProfile(String profileName);*/

//    @Query(value = "SELECT * FROM schema_client1_vms.master_verification_configuration m WHERE m.institute_id=?1" , nativeQuery = true)
    List<MasterVerificationConfiguration> findByInstituteId(String institutionId);

    List<MasterVerificationConfiguration> findByProfileName(String profileName);
}
