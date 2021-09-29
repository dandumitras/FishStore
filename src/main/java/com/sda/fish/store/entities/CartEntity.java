package com.sda.fish.store.entities;

import javax.persistence.*;

@Entity
@Table(name="carts")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer userId;
    private Integer productId;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="userId", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name="productId", insertable = false, updatable = false)
    private ProductEntity product;

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public UserEntity getUser() {
        return user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
