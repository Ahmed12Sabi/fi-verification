package ai.lentra.controller.notification;

import ai.lentra.modal.notification.UserRoleDetails;
import ai.lentra.service.notification.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userRoles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    public UserRoleDetails getUserRoleDetails(String userName, String role, String institutionId){
       return userRoleService.getDetailsByName(userName,role,institutionId);

    }


}
