package com.wildcodeschool.webook.Auth.application;

import com.wildcodeschool.webook.Auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.Auth.domain.service.UserMapper;
import com.wildcodeschool.webook.Auth.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<UserDTO> readAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<?> readOne(@PathVariable Long id){
        return ResponseEntity.status(200).body(userService.getOneUser(id));
    }

    @PostMapping("/users")
    public UserDTO create(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/users/{id}")
    public UserDTO edit(@RequestBody User newUser, @PathVariable Long id) {
        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
