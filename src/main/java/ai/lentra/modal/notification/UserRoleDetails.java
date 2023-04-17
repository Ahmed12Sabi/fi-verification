package ai.lentra.modal.notification;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Embeddable
public class UserRoleDetails {
    @Id
    private long id;
    private String username;
    private String role;
    private String mailId;
    private long mobile;
    private long instituteId;
}
