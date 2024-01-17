package com.wildcodeschool.webook.Auth.application;

import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.Auth.domain.sevice.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> readAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User readOne(@PathVariable Long id){
        return userService.getOneUser(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/users/{id}")
    public User edit(@RequestBody User newUser, @PathVariable Long id) {
        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
