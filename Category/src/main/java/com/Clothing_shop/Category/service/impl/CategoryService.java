package com.Clothing_shop.Category.service.impl;

//import java.util.List;

import com.Clothing_shop.Category.dto.CategoryDto;
import java.util.List;
 
public interface CategoryService {
 
    CategoryDto createCategory(CategoryDto categoryDto);
 
    CategoryDto getCategoryById(Long id);
 
    List<CategoryDto> getAllCategories();
 
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
 
    void deleteCategory(Long id);
}