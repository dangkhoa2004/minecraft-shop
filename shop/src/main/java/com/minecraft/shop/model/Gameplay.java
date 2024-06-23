package com.minecraft.shop.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Gameplay")
public class Gameplay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToMany(mappedBy = "gameplay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product;

    public Gameplay() {
    }

    public Gameplay(int id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
