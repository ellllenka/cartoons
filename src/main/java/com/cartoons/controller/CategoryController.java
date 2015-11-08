package com.cartoons.controller;

import com.cartoons.domain.Category;
import com.cartoons.servise.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MyUser on 28.10.2015.
 */
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
