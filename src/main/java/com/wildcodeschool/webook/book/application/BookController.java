package com.wildcodeschool.webook.book.application;

import com.wildcodeschool.webook.book.domain.entity.Book;
import com.wildcodeschool.webook.book.domain.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> readAll() {
        return bookService.getAllBook();
    }

    @GetMapping("/books/{id}")
    public Book read(@PathVariable Long id) {
        return bookService.getOneBook(id);
    }

    @GetMapping("/books/owner/{ownerId}")
    public List<Book> readByOwnerId(@PathVariable Long ownerId) {
        return bookService.getBooksByOwner(ownerId);
    }

    @GetMapping("/books/categoryId/{categoryId}")
    public List<Book> readByCategoryId(@PathVariable Long categoryId) {
        return bookService.getBooksByCategory(categoryId);
    }

    @PostMapping(value = "/books") //, consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    public Book create(@RequestPart("newBook") Book newBook,
//                       @RequestPart("coverImage") MultipartFile coverImage)
    public Book create(@RequestBody Book newBook)
    {
        System.out.println("Received book: " + newBook);

        // Traitement de la nouvelle image
        // Enregistrement de l'image dans votre système de stockage
        // Liaison de l'image à l'objet Book
        return bookService.createBook(newBook);
    }


    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book newBook, @PathVariable Long id) {
        return bookService.updateBook(newBook, id);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
