package org.fintrack.service;


import org.fintrack.entity.Category;
import org.fintrack.exception.ResourceNotFoundException;
import org.fintrack.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryById(Long id){
        return categoryRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Category not found id: " + id));
    }

    public Category createCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }
}
