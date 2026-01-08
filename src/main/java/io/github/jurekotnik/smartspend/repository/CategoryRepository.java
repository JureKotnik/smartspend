package io.github.jurekotnik.smartspend.repository;

import io.github.jurekotnik.smartspend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}