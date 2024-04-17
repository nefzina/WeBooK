package com.wildcodeschool.webook.fileUpload.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import com.wildcodeschool.webook.book.domain.entity.Book;
import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename", nullable = false)
    private String filename;

    @OneToOne(mappedBy = "profilePicture")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "coverImage")
    @JsonIgnore
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
