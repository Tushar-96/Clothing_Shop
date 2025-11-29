package com.Clothing_shop.Category.service.impl;
 
import com.Clothing_shop.Category.dto.CategoryDto;
import com.Clothing_shop.Category.entity.Category;
import com.Clothing_shop.Category.mapper.CategoryMapper;
import com.Clothing_shop.Category.repository.CategoryRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class CategoryServiceImpl implements CategoryService {
 
    private final CategoryRepository categoryRepository;
 
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
 
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }
 
    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        return CategoryMapper.toDto(category);
    }
 
    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }
 
    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
 
        existing.setName(categoryDto.getName());
        existing.setDescription(categoryDto.getDescription());
 
        Category updated = categoryRepository.save(existing);
 
        return CategoryMapper.toDto(updated);
    }
 
    @Override
    public void deleteCategory(Long id) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
 
        categoryRepository.delete(existing);
    }
}
 