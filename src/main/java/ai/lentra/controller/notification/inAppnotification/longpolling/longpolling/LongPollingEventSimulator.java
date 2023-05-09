package ai.lentra.controller.notification.inAppnotification.longpolling.longpolling;

import ai.lentra.modal.notification.Notification;
import ai.lentra.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

@Component
public class LongPollingEventSimulator {

    private static final Logger LOGGER = Logger.getLogger(LongPollingEventSimulator.class.getName());
    private final BlockingQueue<LongPollingSession> longPollingQueue = new ArrayBlockingQueue<LongPollingSession>(100);

    @Autowired
    private NotificationService dbService;






    private String createMergedMapKey(final String username, final long notificationId) {
        return String.format("%s-%s", username, notificationId);
    }

   /* private List<Notification> mergeNotificationPayloads(final List<Notification> notifications) {
        final Map<String, Notification> mergedNotifications = new ConcurrentHashMap<String, Notification>();
        notifications.stream().forEach(Notification -> {
            final String key = createMergedMapKey(Notification.getUsername(), Notification.getNotificationId().toString());
            if (mergedNotifications.containsKey(key)) {
                final Notification node = mergedNotifications.get(key);
                node.setNotificationPayload(messageUtil.appendMessagePayload(node.getNotificationPayload(), Notification.getNotificationPayload()));
                mergedNotifications.put(key, node);
            }
            mergedNotifications.putIfAbsent(key, Notification);
        });
        return new ArrayList<Notification>(mergedNotifications.values());
    }*/

    // Simulated event handler
    public void simulateIncomingNotification(final String username , final String randomData) {
//        final String randomData = "NotificationMsg";
//                messageUtil.getMessagePayload(); // keep the same payload data per user node
            final Notification notification = new Notification();
            notification.setUsername(username);
            notification.setTimestamp(new Date());
            notification.setNotificationPayload(randomData);
            dbService.save(notification);
        }


    public void simulateOutgoingNotification(final List<Notification> notifications) {
        for (final Notification Notification : notifications) {
            getPollingQueue().stream()
                    .filter(e -> e.getUsername() == Notification.getUsername())
                    .forEach((final LongPollingSession lps) -> {
                        try {
                            lps.getDeferredResult().setResult(Notification.getNotificationPayload());
                        } catch (Exception e) {
                            throw new RuntimeException();
                        }
                    });
        }
        getPollingQueue().removeIf(e -> e.getDeferredResult().isSetOrExpired());
    }

    public BlockingQueue<LongPollingSession> getPollingQueue() {
        return longPollingQueue;
    }
}