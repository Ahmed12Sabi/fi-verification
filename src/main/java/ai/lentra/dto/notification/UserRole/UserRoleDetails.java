package ai.lentra.dto.notification.UserRole;

import lombok.Data;

@Data
public class UserRoleDetails {
    private long id;
    private String username;
    private String role;
    private String mailId;
    private long mobile;
    private long instituteId;
}
