//package com.Clothing_shop.Category.mapper;


package com.Clothing_shop.Category.mapper;
 
import com.Clothing_shop.Category.dto.CategoryDto;
import com.Clothing_shop.Category.entity.Category;
 
public class CategoryMapper {
 
    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
 
    public static Category toEntity(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
 