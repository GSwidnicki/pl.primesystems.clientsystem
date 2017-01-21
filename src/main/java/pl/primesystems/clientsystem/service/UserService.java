package pl.primesystems.clientsystem.service;

import pl.primesystems.clientsystem.entity.User;

public interface UserService {

    void addUserWithDefaultRole(User user);
    User findByEmail(String email);
}
