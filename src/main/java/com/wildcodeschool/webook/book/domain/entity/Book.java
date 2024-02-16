package com.wildcodeschool.webook.book.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "image", nullable = true)
    private String image;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "edition", nullable = true)
    private String edition;
    @Column(name = "review", nullable = true)
    private String review;
    @Column(name = "resume", nullable = true)
    private String resume;
    @Column(name = "ISBN", nullable = true)
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIgnore
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
