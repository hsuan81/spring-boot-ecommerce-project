package com.hsuan.ecommerce.dto;

import com.hsuan.ecommerce.model.Product;

import java.util.List;

public class MultiProduct {
    private List<Product> newComer;
    private List<Product> choice;
    private List<Product> retail;

    public MultiProduct() {
    }

    public MultiProduct(List<Product> newComer, List<Product> choice, List<Product> retail) {
        this.newComer = newComer;
        this.choice = choice;
        this.retail = retail;
    }

    public List<Product> getNewComer() {
        return newComer;
    }

    public void setNewComer(List<Product> newComer) {
        this.newComer = newComer;
    }

    public List<Product> getChoice() {
        return choice;
    }

    public void setChoice(List<Product> choice) {
        this.choice = choice;
    }

    public List<Product> getRetail() {
        return retail;
    }

    public void setRetail(List<Product> retail) {
        this.retail = retail;
    }

    @Override
    public String toString() {
        return "MultiProduct{" +
                "newComer=" + newComer +
                ", choice=" + choice +
                ", retail=" + retail +
                '}';
    }
}
