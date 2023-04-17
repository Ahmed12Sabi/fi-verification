package ai.lentra.repository.notification;

import ai.lentra.modal.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query(value = "select * from notificatio n where n.username=?1", nativeQuery = true)
    List<Notification> getByUserName(String username);
}
