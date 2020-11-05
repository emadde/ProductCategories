package com.dtcc.projects.productcategories.repositories;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
