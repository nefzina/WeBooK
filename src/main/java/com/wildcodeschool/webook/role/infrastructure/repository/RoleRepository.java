package com.wildcodeschool.webook.role.infrastructure.repository;

import com.wildcodeschool.webook.role.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
