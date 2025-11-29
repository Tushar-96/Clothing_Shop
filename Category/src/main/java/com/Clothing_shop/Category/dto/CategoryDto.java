package com.Clothing_shop.Category.dto;



import lombok.*;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
 
    private Long id;
    private String name;
    private String description;
}
 