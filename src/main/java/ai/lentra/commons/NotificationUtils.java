package ai.lentra.commons;

import ai.lentra.modal.notification.Notification;
import ai.lentra.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NotificationUtils {
    @Autowired
    private  NotificationService notificationService;
    public  void invoke(String username,String payload){
        Notification notification= new Notification();
        notification.setTimestamp(new Date());
        notification.setNotificationPayload(payload);
        notification.setUsername(username);
        notificationService.save(notification);
    }
}
