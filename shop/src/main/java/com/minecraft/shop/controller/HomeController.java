/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minecraft.shop.controller;

import com.minecraft.shop.model.*;
import com.minecraft.shop.repository.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author 04dkh
 */
@Controller
public class HomeController {

    // category
    @Autowired
    private GameplayRepository gameplayRepo;
    @Autowired
    private PlatformRepository platformRepo;
    @Autowired
    private VersionRepository versionRepo;
    // about product
    @Autowired
    private ProductRepository productRepo;

    private void fillCategory(Model model) {
        List<Gameplay> gameplay = gameplayRepo.findAll();
        List<Platform> platform = platformRepo.findAll();
        List<Version> version = versionRepo.findAll();
        model.addAttribute("gameplay", gameplay);
        model.addAttribute("platform", platform);
        model.addAttribute("version", version);
    }

    private void allforProduct(Model model) {
        List<Product> lstProduct = productRepo.findAll();
        // setGameplayNames
        lstProduct.forEach(product -> {
            String gameplayNames = product.getGameplay().stream()
                    .map(Gameplay::getName)
                    .collect(Collectors.joining(", "));
            product.setGameplayNames(gameplayNames);
        });
        // setPlatformNames
        lstProduct.forEach(product -> {
            String platformNames = product.getPlatform().stream()
                    .map(Platform::getName)
                    .collect(Collectors.joining(", "));
            product.setPlatformNames(platformNames);
        });
        // setVersionNames
        lstProduct.forEach(product -> {
            String versionNames = product.getVersion().stream()
                    .map(Version::getName)
                    .collect(Collectors.joining("+ "));
            product.setVersionNames(versionNames);
        });
        model.addAttribute("lstProduct", lstProduct);
    }

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("HOME PAGE");
        model.addAttribute("page", "home");
        allforProduct(model);
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        System.out.println("SHOP PAGE");
        model.addAttribute("page", "shop");
        allforProduct(model);
        return "shop";
    }

    @GetMapping("/community")
    public String community(Model model) {
        model.addAttribute("page", "community");
        return "community";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("page", "support");
        return "support";
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("page", "account");
        return "account";
    }
}
