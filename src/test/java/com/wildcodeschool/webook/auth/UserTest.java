package com.wildcodeschool.webook.auth;

import com.wildcodeschool.webook.Auth.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testUserId() {
        Long id = 1L;
        user.setId(id);
        assertEquals(user.getId(), id);
    }

    @Test
    public void testUserEmail() {
        String email = "test@mail.com";
        user.setEmail(email);
        assertEquals(user.getEmail(), email);
    }
}
