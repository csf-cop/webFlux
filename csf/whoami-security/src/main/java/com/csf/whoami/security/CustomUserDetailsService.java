package com.csf.whoami.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csf.whoami.entity.UsersEntity;
import com.csf.whoami.exception.ResourceNotFoundException;
import com.csf.whoami.service.UserService;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService service;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UsersEntity user = service.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + username)
        );

        return CustomUserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        UsersEntity user = service.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return CustomUserPrincipal.create(user);
    }
}