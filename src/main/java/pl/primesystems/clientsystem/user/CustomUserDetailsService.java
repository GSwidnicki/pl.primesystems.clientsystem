package pl.primesystems.clientsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.primesystems.clientsystem.user.User;
import pl.primesystems.clientsystem.user.UserServiceImpl;
import pl.primesystems.clientsystem.user.role.UserRole;

import java.util.HashSet;
import java.util.Set;

import static pl.primesystems.clientsystem.config.Keys.USER_DOES_NOT_EXIST;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            System.out.println("*** NIE ZNALEZIONO TAKIEGO UŻYTKOWNIKA! ***");
            throw new UsernameNotFoundException(USER_DOES_NOT_EXIST);
        }
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            convertAuthorities(user.getRoles()));
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(UserRole ur: userRoles) {
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }


}
