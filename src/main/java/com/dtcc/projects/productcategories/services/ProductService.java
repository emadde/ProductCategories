package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> showAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, String Name, String description, Double price){
        Product product= findById(id);
        if (Name!= null) {
            product.setProductName(Name);
        } else {
            product.setProductName(product.getProductName());
        }
        if(description!= null){
            product.setDescription(description);
        } else {
            product.setDescription(product.getDescription());
        }
        if(price!= null){
            product.setPrice(price);
        } else {
            product.setPrice(product.getPrice());
        }

        product.setUpdatedAt(new Date());
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

//    public List<Product> findByCategoriesNotContains(Category category) {
//        return productRepository.findByCategoriesNotContains(category);
//    }
}
