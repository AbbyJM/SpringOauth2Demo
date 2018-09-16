package com.abby.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsImp implements UserDetails {

    private String password;
    private String username;
    private String phone;
    private String email;
    private List<GrantedAuthority> authorities=new ArrayList<>();

    public UserDetailsImp(String password,String username,List<GrantedAuthority> privilege){
        this.password=password;
        this.username=username;
        authorities.clear();
        authorities.addAll(privilege);
        phone=null;
        email=null;
    }

    public UserDetailsImp(String password,String username,String phone,String email,List<GrantedAuthority> privilege){
        this.email=email;
        this.phone=phone;
        this.password=password;
        this.username=username;
        authorities.clear();
        authorities.addAll(privilege);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    /**
     * assume that all the status of this account is normal
     */
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
        return true;
    }
}
