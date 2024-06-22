package com.minecraft.shop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

    @Id
    private int id;

    private String name;

}
