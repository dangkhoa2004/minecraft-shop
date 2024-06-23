/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minecraft.shop.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "Imageurl")
public class Imageurl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Imageurl() {
    }

    public Imageurl(int id, String url, Product product) {
        this.id = id;
        this.url = url;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
