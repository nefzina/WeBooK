package com.wildcodeschool.webook.Auth.domain.service;

import com.wildcodeschool.webook.Auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDTO transformUserEntityInUserDTO(User user) {
        return new UserDTO(
                user.getEmail(),
                user.getUsername(),
                user.getZip_code(),
                user.getCity(),
                user.getRole(),
                user.getPreferences(),
                user.getBooks(),
                true);
    }
}
