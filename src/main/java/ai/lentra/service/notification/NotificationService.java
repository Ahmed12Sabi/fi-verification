package ai.lentra.service.notification;

import ai.lentra.modal.notification.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotifications(String username);

    void save(Notification notification);
}

