package com.dtcc.projects.productcategories.repositories;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.CategoryService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
//    List<Category> findByProductsNotContains(Product product);
}
