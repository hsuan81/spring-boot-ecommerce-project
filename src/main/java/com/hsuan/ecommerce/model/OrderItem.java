package com.hsuan.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Product product;

    @ManyToOne(optional = false)
    @Column(name = "order_id", nullable = false)
    private Order order;

    private Integer quantity;

    private Integer price;

    public OrderItem() {
    }

    public OrderItem(Product product, Integer quantity, Integer price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
