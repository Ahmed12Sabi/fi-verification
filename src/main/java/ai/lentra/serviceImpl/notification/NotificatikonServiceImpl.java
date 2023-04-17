package ai.lentra.serviceImpl.notification;

import ai.lentra.modal.notification.Notification;
import ai.lentra.repository.notification.NotificationRepository;
import ai.lentra.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class NotificatikonServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository repository;
    @Override
    public List<Notification> getNotifications(String username) {
        return repository.getByUserName(username);
    }

    @Override
    public void save(Notification notification) {
    repository.save(notification);
    }
}
