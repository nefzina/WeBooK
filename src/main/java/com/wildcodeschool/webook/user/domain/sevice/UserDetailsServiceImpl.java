package com.wildcodeschool.webook.user.domain.sevice;

import com.wildcodeschool.webook.book.infrastructure.exception.NotFoundException;
import com.wildcodeschool.webook.user.domain.dto.UserPrincipal;
import com.wildcodeschool.webook.user.infrastructure.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public abstract class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserPrincipal loadUserByEmail(String email) throws NotFoundException {
        return new UserPrincipal(userRepository.findByEmail(email));
    }
}
