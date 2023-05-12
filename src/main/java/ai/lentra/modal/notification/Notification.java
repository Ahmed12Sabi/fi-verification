package ai.lentra.modal.notification;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Embeddable
@Entity
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private Date timestamp;

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotificationPayload() {
        return notificationPayload;
    }

    public void setNotificationPayload(String notificationPayload) {
        this.notificationPayload = notificationPayload;
    }

    private String username;

    private String notificationPayload;

}
