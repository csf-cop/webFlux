package com.csf.whoami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csf.whoami.entity.UsersEntity;
import com.csf.whoami.exception.ResourceNotFoundException;
import com.csf.whoami.security.CurrentUser;
import com.csf.whoami.security.CustomUserPrincipal;
import com.csf.whoami.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UsersEntity getCurrentUser(@CurrentUser CustomUserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
