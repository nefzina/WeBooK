package com.wildcodeschool.webook.Auth.domain.service;

import com.wildcodeschool.webook.Auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.Auth.infrastructure.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder bcryptPwEncoder;
    private final UserMapper userMapper;

    public UserRegistrationService(UserRepository repository, BCryptPasswordEncoder bcryptPwEncoder, UserMapper userMapper) {
        this.repository = repository;
        this.bcryptPwEncoder = bcryptPwEncoder;
        this.userMapper = userMapper;
    }

    public UserDTO registration(User userData) {

        User userEntity = repository.findByEmail(userData.getEmail());
        if (userEntity != null) {
            throw new RuntimeException("Cette adresse mail existe déjà");
        } else {
            userData.setPassword(bcryptPwEncoder.encode(userData.getPassword()));
            try {
                User user = repository.save(userData);
                return userMapper.transformUserEntityInUserDTO(user);

            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}