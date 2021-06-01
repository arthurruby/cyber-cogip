package fr.cogip.cybercogip.auth;

import fr.cogip.cybercogip.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CogipUserPrincipal implements UserDetails {

    private final User user;

    public CogipUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive();
    }
}
