package com.dtcc.projects.productcategories.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories_products")
public class Association {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_ID")
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_ID")
    private Category categoryID;

    @Column(name = "Created_At")
    private Date createdAt;

    @Column(name = "Updated_At")
    private Date updatedAt;

    public Association(Product productId, Category categoryID) {
        this.productId = productId;
        this.categoryID = categoryID;
    }
}
