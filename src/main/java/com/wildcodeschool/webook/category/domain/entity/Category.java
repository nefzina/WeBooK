package com.wildcodeschool.webook.category.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "category", nullable = false)
    private String type;

    public Category(Long category_id, String type) {
        this.category_id = category_id;
        this.type = type;
    }

    public Long getCategory_id() {return category_id;}

    public void setCategory_id(Long category_id) {this.category_id = category_id;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
