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

    @Transient
    private String gameplayNames;

    @ManyToMany
    @JoinTable(
            name = "Product_Platform",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platform;

    @Transient
    private String platformNames;

    @ManyToMany
    @JoinTable(
            name = "Product_Version",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "version_id")
    )
    private Set<Version> version;

    @Transient
    private String versionNames;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imageurl> imageUrl;

    public Product() {
    }

    public Product(int id, String name, String description, int price, Set<Gameplay> gameplay, String gameplayNames, Set<Platform> platform, String platformNames, Set<com.minecraft.shop.model.Version> version, String versionNames, List<Imageurl> imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.gameplay = gameplay;
        this.gameplayNames = gameplayNames;
        this.platform = platform;
        this.platformNames = platformNames;
        this.version = version;
        this.versionNames = versionNames;
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

    public String getGameplayNames() {
        return gameplayNames;
    }

    public void setGameplayNames(String gameplayNames) {
        this.gameplayNames = gameplayNames;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(Set<Platform> platform) {
        this.platform = platform;
    }

    public String getPlatformNames() {
        return platformNames;
    }

    public void setPlatformNames(String platformNames) {
        this.platformNames = platformNames;
    }

    public Set<com.minecraft.shop.model.Version> getVersion() {
        return version;
    }

    public void setVersion(Set<com.minecraft.shop.model.Version> version) {
        this.version = version;
    }

    public String getVersionNames() {
        return versionNames;
    }

    public void setVersionNames(String versionNames) {
        this.versionNames = versionNames;
    }

    public List<Imageurl> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<Imageurl> imageUrl) {
        this.imageUrl = imageUrl;
    }

}
