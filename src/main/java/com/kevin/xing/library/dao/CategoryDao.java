package com.kevin.xing.library.dao;

import com.kevin.xing.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
