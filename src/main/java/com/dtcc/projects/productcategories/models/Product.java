package com.dtcc.projects.productcategories.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name ="PRODUCT_NAME")
    private String productName;

    @Column(name ="DESCRIPTION")
    private String description;

    @Column(name ="PRICE")
    private Double price;

    @Column(name ="CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;


    @ManyToMany
    @JoinTable(name="categories_products", joinColumns = @JoinColumn(name ="product_Id"), inverseJoinColumns = @JoinColumn(name = "category_Id"))
    private List <Category> categoryList;
    public Product(String productName, String description, Double price, Date createdAt, Date updatedAt) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
