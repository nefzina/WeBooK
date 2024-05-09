package com.wildcodeschool.webook.book.infrastructure.repository;

import com.wildcodeschool.webook.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
List<Book> findBooksByBookCategory(Long categoryId);
List<Book> findBooksByOwner(Long ownerId);
}
