package com.wildcodeschool.webook.user.domain.sevice;

import com.wildcodeschool.webook.user.domain.entity.User;
import com.wildcodeschool.webook.user.infrastructure.exception.NotFoundException;
import com.wildcodeschool.webook.user.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAllUsers(){
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
}
