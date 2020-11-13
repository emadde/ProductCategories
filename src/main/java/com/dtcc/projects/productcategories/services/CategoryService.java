package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    public List<Category> showAll(){
        return categoryRepository.findAll();
    }

    public Category findByID(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory (Long id, String name){
        Category category=findByID(id);
        if( name!= null) {
            category.setCategoryName(name);
        } else{
            category.setCategoryName(category.getCategoryName());
        }

        category.setUpdatedAt(new Date());

        return categoryRepository.save(category);
    }

    public void deletById (Long id) {
        categoryRepository.deleteById(id);
    }

//    public List <Category> findByProductsNotContains(Product product) {
//        return categoryRepository.findByProductsNotContains(product);
//    }
}

