package com.wildcodeschool.webook.Auth.domain.sevice;

import com.wildcodeschool.webook.Auth.domain.dto.UserPrincipal;
import com.wildcodeschool.webook.book.infrastructure.exception.NotFoundException;
import com.wildcodeschool.webook.Auth.infrastructure.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserPrincipal loadUserByEmail(String email) throws NotFoundException {
        return new UserPrincipal(userRepository.findByEmail(email));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
