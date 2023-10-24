package com.example.App_api.controller;

import com.example.App_api.model.Category;

import com.example.App_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public Page<Category> getListCategory(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                          @RequestParam(name = "sort", required = false, defaultValue = "id") String sort){
        org.springframework.data.domain.Page<Category> categories= categoryService.findCategory(page,size,sort);
        return categories;
    }

    @GetMapping("/active")
    private List<Category> active(){
        return categoryService.getListCategoryActive();
    }
    @GetMapping("/home")
    public List<Category> getTourHomeActive(){
        return  categoryService.getCategoryHome();
    }
}
