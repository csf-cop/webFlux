package com.csf.whoami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csf.whoami.domain.GroupDTO;
import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.security.CurrentUser;
import com.csf.whoami.security.UserPrincipal;
import com.csf.whoami.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserDTO getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId());
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/groups")
    @PreAuthorize("hasRole('USER')")
    public List<GroupDTO> getListGroupsByUser() {
    	return null;
    }
}
