package com.csf.whoami.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserDTO user = userService.findByUsername(username);
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username : " + username)
//        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        UserDTO user = userService.findById(id);
//        		.orElseThrow(
//            () -> new ResourceNotFoundException("User", "id", id)
//        );

        return UserPrincipal.create(user);
    }
}