package fr.cogip.cybercogip.auth;

import fr.cogip.cybercogip.models.User;
import fr.cogip.cybercogip.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CogipUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CogipUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user){
            throw new UsernameNotFoundException("Cannot find username: " + username);
        }
        return new CogipUserPrincipal(user);
    }
}