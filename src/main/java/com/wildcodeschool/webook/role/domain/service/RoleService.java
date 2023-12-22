package com.wildcodeschool.webook.role.domain.service;

import com.wildcodeschool.webook.role.domain.entity.Role;
import com.wildcodeschool.webook.role.infrastructure.repository.RoleRepository;
import com.wildcodeschool.webook.user.infrastructure.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    RoleRepository repository;
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }
    public Role readOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Role createRole(Role newRole) {
        return repository.save(newRole);
    }
}
