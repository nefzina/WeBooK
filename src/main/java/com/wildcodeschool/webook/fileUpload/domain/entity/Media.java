package com.wildcodeschool.webook.fileUpload.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildcodeschool.webook.Auth.domain.entity.User;
import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename", nullable = false)
    private String fileName;

    @OneToOne(mappedBy = "profilePicture")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
