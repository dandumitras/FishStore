package com.sda.fish.store.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;
    private String weight;
    private Double price;
    private Integer quantity;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="categoryId")//refera cheia primara din Category
    private CategoriesEntity category;

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }



    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
