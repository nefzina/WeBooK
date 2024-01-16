package com.wildcodeschool.webook.book.infrastructure.repository;

import com.wildcodeschool.webook.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

}
