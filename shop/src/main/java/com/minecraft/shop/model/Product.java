package com.minecraft.shop.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    private int id;
    private String name;
    private String description;
    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Product_Gameplay",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "gameplay_id")
    )
    private Set<Gameplay> gameplay;

    @ManyToMany
    @JoinTable(
            name = "Product_Platform",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platform;

    @ManyToMany
    @JoinTable(
            name = "Product_Version",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "version_id")
    )
    private Set<Version> version;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imageurl> imageUrl;

    public Product() {
    }

    public Product(int id, String name, String description, int price, Set<Gameplay> gameplay, Set<Platform> platform, Set<Version> version, List<Imageurl> imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.gameplay = gameplay;
        this.platform = platform;
        this.version = version;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Gameplay> getGameplay() {
        return gameplay;
    }

    public void setGameplay(Set<Gameplay> gameplay) {
        this.gameplay = gameplay;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(Set<Platform> platform) {
        this.platform = platform;
    }

    public Set<Version> getVersion() {
        return version;
    }

    public void setVersion(Set<Version> version) {
        this.version = version;
    }

    public List<Imageurl> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<Imageurl> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
