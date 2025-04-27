package com.ijse.bookstore.service;



import com.ijse.bookstore.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {
    public List<Category> getAllCategory();
}
