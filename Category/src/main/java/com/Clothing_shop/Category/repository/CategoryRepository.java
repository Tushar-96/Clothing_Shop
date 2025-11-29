package com.Clothing_shop.Category.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Clothing_shop.Category.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	 boolean existsByName(String name);
 
}