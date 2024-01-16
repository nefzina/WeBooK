package com.wildcodeschool.webook.book.domain.service;

import com.wildcodeschool.webook.book.domain.entity.Book;
import com.wildcodeschool.webook.book.infrastructure.repository.BookRepository;
import com.wildcodeschool.webook.book.infrastructure.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBook() {
        return repository.findAll();
    }

    public Book getOneBook(Long id) {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public Book createBook(Book newBook) {
        return repository.save(newBook);
    }

    public Book updateBook(Book newBook, Long id) {
        return repository.findById(id)
                .map(book -> {
                    book.setName(newBook.getName());
                    book.setOwnerId(newBook.getOwnerId());
                    book.setImage(newBook.getImage());
                    book.setAuthor(newBook.getAuthor());
                    book.setEdition(newBook.getEdition());
                    book.setResume(newBook.getResume());
                    book.setIsbn(newBook.getIsbn());
                    book.setReview(newBook.getReview());


                    return repository.save(book);
                })
                .orElseThrow(NotFoundException::new);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);

    }

    public List<Book> getAllUsers() {
        return repository.findAll();
    }
}
