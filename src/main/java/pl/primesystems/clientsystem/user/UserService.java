package pl.primesystems.clientsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static pl.primesystems.clientsystem.config.Keys.DEFAULT_USER_ROLE;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserService(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addUserWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_USER_ROLE);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }
}
