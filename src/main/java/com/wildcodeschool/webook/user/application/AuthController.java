package com.wildcodeschool.webook.user.application;

import com.wildcodeschool.webook.user.domain.dto.UserDTO;
import com.wildcodeschool.webook.user.domain.entity.User;
import com.wildcodeschool.webook.user.domain.sevice.JwtService;
import com.wildcodeschool.webook.user.domain.sevice.UserDetailsServiceImpl;
import com.wildcodeschool.webook.user.domain.sevice.UserRegistrationService;
import com.wildcodeschool.webook.user.domain.sevice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRegistrationService userRegistrationService;

    public  AuthController(UserService userService,
                           JwtService jwtService,
                           UserDetailsServiceImpl userDetailsService,
                           UserRegistrationService userRegistrationService){
        this.userService = userService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.userRegistrationService = userRegistrationService;
    }

@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userBody) throws Exception {
        try{
            userService.login(userBody);
                String token = jwtService.generateToken(userDetailsService.loadUserByEmail(userBody.getEmail()));
            return  ResponseEntity.ok(token);

        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userBody) throws Exception {
        try{
            UserDTO res = userRegistrationService.registration(userBody);
            return ResponseEntity.status(201).body(res);

        }catch (BadCredentialsException e){
            return ResponseEntity.status(400).build();
        }
    }
}
