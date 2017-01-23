package pl.primesystems.clientsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.primesystems.clientsystem.entity.User;
import pl.primesystems.clientsystem.entity.UserRole;
import pl.primesystems.clientsystem.repository.UserRoleRepository;
import pl.primesystems.clientsystem.repository.UserRepository;

import static pl.primesystems.clientsystem.config.Keys.DEFAULT_USER_ROLE;

@Service
@Transactional
public class UserService {

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
