package pl.primesystems.clientsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.primesystems.clientsystem.user.role.UserRole;
import pl.primesystems.clientsystem.user.role.UserRoleRepository;

import static pl.primesystems.clientsystem.config.Keys.DEFAULT_USER_ROLE;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addUserWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_USER_ROLE);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
