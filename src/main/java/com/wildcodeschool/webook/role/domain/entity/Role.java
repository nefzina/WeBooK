package com.wildcodeschool.webook.role.domain.entity;

import com.wildcodeschool.webook.user.domain.entity.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH)
    private List<User> users;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
