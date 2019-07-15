package com.csf.whoami.security.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.csf.whoami.security.entity.AppUser;
import com.csf.whoami.security.entity.UserInfo;
import com.csf.whoami.security.repository.AppUserRepository;

public class DefaultUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public DefaultUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<AppUser> userEntity = appUserRepository.findById(username);

        if (userEntity.isPresent()) {
            final AppUser appUser = userEntity.get();

            UserInfo info = new UserInfo(appUser.getUserEmail(),
                    passwordNoEncoding(appUser),
                    Collections.singletonList(new SimpleGrantedAuthority(appUser.getUserRole())));
            info.setUserRole(appUser.getUserRole());

            return info;
        }

        // TODO: Test new User
        AppUser appUser = new AppUser();
        UserInfo info = new UserInfo("PC-user", passwordNoEncoding(appUser),
                Collections.singletonList(new SimpleGrantedAuthority("Anonymous")));
        info.setUserRole("Anonymous");
        return info;

        //return null;
    }

    private String passwordNoEncoding(AppUser appUser) {
        // you can use one of bcrypt/noop/pbkdf2/scrypt/sha256
        // more: https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-encoding
        return "{noop}" + appUser.getUserPass();
    }
}
