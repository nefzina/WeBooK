package com.wildcodeschool.webook.auth.domain.service;

import com.wildcodeschool.webook.auth.domain.dto.UserPrincipal;
import com.wildcodeschool.webook.auth.infrastructure.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.wildcodeschool.webook.auth.domain.dto.UserPrincipal;
import com.wildcodeschool.webook.auth.domain.entity.User;
import com.wildcodeschool.webook.auth.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.findByUsername(username));
    }
}
