package pl.primesystems.clientsystem.user;

public interface UserService {

    void addUserWithDefaultRole(User user);
    User findByEmail(String email);
}
