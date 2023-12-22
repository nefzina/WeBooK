package com.wildcodeschool.webook.book.application;

import com.wildcodeschool.webook.book.domain.entity.Book;
import com.wildcodeschool.webook.book.domain.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController

    public class BookController {
        BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @GetMapping("/book")
        public List<Book> readAll() {
            return bookService.getAllBook();
        }

        @GetMapping("/book/{id}")
        public Book searchOne(@PathVariable Long id) {
            return bookService.getOneBook(id);
        }

        @PostMapping("/book/new")
        public Book add(@RequestBody Book newBook) {
            return bookService.createBook(newBook);
        }

        @PutMapping("/book/update/{id}")
        public Book update(@RequestBody Book newBook, @PathVariable Long id) {
            return bookService.updateBook(newBook, id);
        }

        @DeleteMapping("/book/delete/{id}")
        public void delete(@PathVariable Long id) {
            bookService.deleteBook(id);
        }
    }



