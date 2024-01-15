package com.wildcodeschool.webook.book.domain.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildcodeschool.webook.role.domain.entity.Role;
import com.wildcodeschool.webook.user.domain.entity.User;
import jakarta.persistence.*;



@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "ownerById", nullable = false)
    private String ownerById;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "edition", nullable = true)
    private String edition;

    @Column(name = "review", nullable = true)
    private String review;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "User_id", nullable = false)
    @JsonIgnore
    private User user;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerById() {
        return ownerById;
    }

    public void setOwnerById(String ownerById) {
        this.ownerById = ownerById;
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

    @Column(name = "resume", nullable = true)
    private String resume;

    @Column(name = "ISBN", nullable = true)
    private String isbn;









}
