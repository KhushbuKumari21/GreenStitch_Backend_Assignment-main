package com.GreenStitch.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.GreenStitch.model.UserInfo;

public class MyUserDetails implements UserDetails {

    private UserInfo user;

    public MyUserDetails(UserInfo user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole());
        authorities.add(sga);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Placeholder implementation, add custom logic if needed
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Placeholder implementation, add custom logic if needed
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Placeholder implementation, add custom logic if needed
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Placeholder implementation, add custom logic if needed
        return true;
    }
}
