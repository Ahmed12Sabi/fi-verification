package ai.lentra.serviceImpl.notification;

import ai.lentra.modal.notification.UserRoleDetails;
import ai.lentra.repository.notification.UserRoleRepository;
import ai.lentra.service.notification.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleDetails getDetailsByName(String userName, String role, String institutionId) {
        return userRoleRepository.findUser(userName,role,institutionId);
    }
}
