package com.wildcodeschool.webook.Auth.domain.dto;

import com.wildcodeschool.webook.book.domain.entity.Book;
import com.wildcodeschool.webook.book.domain.entity.Category;
import com.wildcodeschool.webook.Auth.domain.entity.Role;

import java.util.List;

public record UserDTO(
        String email,
        String username,
        Number zip_code,
        String city,
        Role role,
        List<Category> preferences,
        List<Book> books
) {
}
