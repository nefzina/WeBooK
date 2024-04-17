package com.wildcodeschool.webook.Auth.application;

import com.wildcodeschool.webook.Auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.Auth.domain.entity.Token;
import com.wildcodeschool.webook.Auth.domain.service.*;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.Auth.infrastructure.exception.RegistrationErrorException;
import org.springframework.http.*;
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
    private final CookieService cookieService;

    public AuthController(UserService userService, JwtService jwtService, UserDetailsServiceImpl userDetailsService,
                          UserRegistrationService userRegistrationService, CookieService cookieService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.userRegistrationService = userRegistrationService;
        this.cookieService = cookieService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE) // produces : renvoyer du json et pas du texte
    public ResponseEntity<?> login(@RequestBody User userBody) throws Exception {
        try {
            userService.login(userBody);
            Token token = jwtService.generateToken(userDetailsService.loadUserByEmail(userBody.getEmail()));

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookieService.createCookie(token).toString())
                    .build();

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userBody) throws RegistrationErrorException {
        try {
            UserDTO res = userRegistrationService.registration(userBody);
            return ResponseEntity.status(201).body(res);

        } catch (Exception e) {
            throw new RegistrationErrorException(e.getMessage());
        }
    }
}
