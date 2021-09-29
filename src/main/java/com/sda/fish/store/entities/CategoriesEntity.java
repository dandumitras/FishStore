package com.sda.fish.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
