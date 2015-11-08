package com.cartoons.servise;

import com.cartoons.domain.Cartoon;
import com.cartoons.domain.Category;
import com.cartoons.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by MyUser on 28.10.2015.
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}


