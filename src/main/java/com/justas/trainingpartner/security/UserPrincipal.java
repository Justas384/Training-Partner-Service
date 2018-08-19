package com.justas.trainingpartner.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justas.trainingpartner.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private int id;
    private String username;

    @JsonIgnore
    private String password;
    private boolean enabled;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(int id, String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getAuthorities().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getAuthority())
        ).collect(Collectors.toList());

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getEnabled(), authorities);
    }

    public int getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        UserPrincipal userPrincipal = (UserPrincipal) object;

        return Objects.equals(id, userPrincipal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}