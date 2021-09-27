package com.kevin.xing.library.service;

import com.kevin.xing.library.dao.CategoryDao;
import com.kevin.xing.library.model.Category;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryDao categoryDao;

    public List<Category> findList() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(Sort.Order.desc("id"));
        return categoryDao.findAll(Sort.by(orders));
    }

    public Category findInfo(int id) {
        return categoryDao.findById(id).orElse(null);
    }
}
