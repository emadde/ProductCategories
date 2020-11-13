package com.dtcc.projects.productcategories.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToMany
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_Id"), inverseJoinColumns = @JoinColumn(name = "product_Id"))
    private List<Product> productList;


    public Category(String value, Date created_at, Date updated_at) {
        this.categoryName = value;
        this.createdAt = created_at;
        this.updatedAt = updated_at;
    }
}