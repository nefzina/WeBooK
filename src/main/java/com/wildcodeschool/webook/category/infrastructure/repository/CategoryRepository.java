package com.wildcodeschool.webook.category.infrastructure.repository;

import com.wildcodeschool.webook.category.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
