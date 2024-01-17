package com.wildcodeschool.webook.user.domain.dto;

import com.wildcodeschool.webook.book.domain.entity.Book;
import com.wildcodeschool.webook.category.domain.entity.Category;
import com.wildcodeschool.webook.role.domain.entity.Role;

import java.util.List;

public record UserDTO(
        String username,
        String email,
        Number zip_code,
        String city,
        Role role,
        List<Category> preferences,
        List<Book> books,
        boolean isEnabled
) {
}
