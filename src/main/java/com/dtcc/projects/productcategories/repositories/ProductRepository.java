package com.dtcc.projects.productcategories.repositories;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    List<Product> findByCategoriesNotContains(Category category);
}
