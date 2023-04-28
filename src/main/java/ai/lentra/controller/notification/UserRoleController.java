package ai.lentra.controller.notification;

import ai.lentra.modal.notification.UserRoleDetails;
import ai.lentra.service.notification.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userRoles")
public class UserRoleController {
    private static final Logger logger =  LoggerFactory.getLogger(UserRoleController.class);
    @Autowired
    private UserRoleService userRoleService;

    public UserRoleDetails getUserRoleDetails(String userName, String role, String institutionId){
        logger.info("Entered into getUserRoleDetails ");
       return userRoleService.getDetailsByName(userName,role,institutionId);

    }


}
