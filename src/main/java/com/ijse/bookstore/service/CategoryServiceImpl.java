package com.ijse.bookstore.service;


import com.ijse.bookstore.entity.Category;
import com.ijse.bookstore.repository.CategoryReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryReposirory categoryReposirory;

    @Override
    public List<Category> getAllCategory() {
        return categoryReposirory.findAll();
    }
}
