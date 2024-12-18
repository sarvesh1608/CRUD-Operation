package com.product.product.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String description;
    private double price;
    private Integer quantity;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
    return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

