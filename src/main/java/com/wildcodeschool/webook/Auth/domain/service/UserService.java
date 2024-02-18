package com.wildcodeschool.webook.Auth.domain.service;

import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.Auth.infrastructure.exception.NotFoundException;
import com.wildcodeschool.webook.Auth.infrastructure.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder bcryptPwEncoder;

    public UserService(UserRepository repository,
                       BCryptPasswordEncoder bcryptPwEncoder) {
        this.repository = repository;
        this.bcryptPwEncoder = bcryptPwEncoder;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getOneUser(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public User createUser(User newUser) {
        return repository.save(newUser);
    }

    public User updateUser(User newUser, Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setCity(newUser.getCity());
                    user.setZip_code(newUser.getZip_code());

                    return repository.save(user);
                })
                .orElseThrow(NotFoundException::new);
    }
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User login(User user) {
        User userEntity = getUserEntityByEmail(user.getEmail());
        if (!bcryptPwEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            throw new NotFoundException();
        }
        user.setRole(userEntity.getRole());
        return user;
    }

    public User getUserEntityByEmail(String email) {
        try {
            return repository.findByEmail(email);

        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
