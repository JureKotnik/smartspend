package io.github.jurekotnik.smartspend.controller;

import io.github.jurekotnik.smartspend.entity.Category;
import io.github.jurekotnik.smartspend.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
        return repository.save(category);
    }
}