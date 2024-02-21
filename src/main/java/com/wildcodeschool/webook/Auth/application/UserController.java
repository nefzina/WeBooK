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

//    @GetMapping("/users")
//    public List<UserDTO> readAll(){
//        return userMapper.transformUserEntityInUserDTO(userService.getAllUsers());
//    }

//    @GetMapping("/users/{id}")
//    public UserDTO readOne(@PathVariable Long id){
//        return userMapper.transformUserEntityInUserDTO(userService.getOneUser(id));
//    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<?> readOne(@PathVariable Long id){
//        System.err.println(userMapper.transformUserEntityInUserDTO(userService.getOneUser(id)));
        UserDTO res = userMapper.transformUserEntityInUserDTO(userService.getOneUser(id));
        return ResponseEntity.status(200).body(res);

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
