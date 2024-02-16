package com.wildcodeschool.webook.Auth.domain.sevice;

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

    public UserDTO registration(User userData) throws Exception {
        userData.setPassword(bcryptPwEncoder.encode(userData.getPassword()));
        userData.setRole(2);

        try {
            System.out.println(userData.getEmail());
            System.out.println(userData.getPassword());
            System.out.println(userData.getUsername());
            System.out.println(userData.getCity());
            System.out.println(userData.getRole());
            System.out.println(userData.getZip_code());
            System.out.println(userData.getBooks());

            User user = repository.save(userData);

            return userMapper.transformUserEntityInUserDTO(user);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
