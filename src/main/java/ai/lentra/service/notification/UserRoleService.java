package ai.lentra.service.notification;

import ai.lentra.modal.notification.UserRoleDetails;

public interface UserRoleService {
    UserRoleDetails getDetailsByName(String userName, String role, String institutionId);
}
