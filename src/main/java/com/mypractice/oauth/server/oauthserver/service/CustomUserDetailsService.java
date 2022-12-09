package com.mypractice.oauth.server.oauthserver.service;

import com.mypractice.oauth.server.oauthserver.entity.User;
import com.mypractice.oauth.server.oauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public record CustomUserDetailsService(UserRepository userRepository) implements UserDetailsService {

    @Override
    public User loadUserByUsername(final String userName) {
        final var user = userRepository.findByUsername(userName);
        if (!user.isPresent())
            throw new BadCredentialsException("Bad credentials");
        new AccountStatusUserDetailsChecker().check(user.get());
        return user.get();
    }
}