package ai.lentra.repository.notification;

import ai.lentra.modal.notification.UserRoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleDetails, Long> {

    @Query(value = "select u.username, u.role, u.institute_id, u,mail_id form user_role_details u where u.username=?1, u.role=?2 and u.institute_id=?3", nativeQuery = true )
    UserRoleDetails findUser(String userName, String role, String institutionId);
}
