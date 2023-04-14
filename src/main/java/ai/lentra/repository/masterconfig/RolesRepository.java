package ai.lentra.repository.masterconfig;


import ai.lentra.modal.masterconfig.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {

    RolesEntity findByRoleId(Long applicantId);
    RolesEntity findByRoleName(String RoleName);

    List<RolesEntity> findAllByRoleName(String RoleName);
    RolesEntity findByRoleNameAndVmsRoleName(String RoleName,String VmsRoleName);
    @Query(value = "SELECT count(*) FROM role_config r WHERE r.role_id=?1 and r.role_name =?2 and r.vms_role_name =?3" , nativeQuery = true)
    Long countByRoleIdAndRoleNameAndVmsRoleName( Long id, String RoleName,String VmsRoleName);
    /*@Query(value = "SELECT * FROM master_verification_configuration m WHERE m.profile_name=?1" , nativeQuery = true)
    List<MasterVerificationConfiguration> findByProfile(String profileName);*/
    Long countByRoleNameAndVmsRoleName(String RoleName,String VmsRoleName);
    Long countByRoleName(String RoleName);

}
