/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minecraft.shop.controller;

import com.minecraft.shop.model.*;
import com.minecraft.shop.repository.*;
import java.util.List;
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
    @Autowired
    private ImageurlRepository imageurlRepo;

    private void fillCategory(Model model) {
        List<Gameplay> gameplay = gameplayRepo.findAll();
        List<Platform> platform = platformRepo.findAll();
        List<Version> version = versionRepo.findAll();
        model.addAttribute("gameplay", gameplay);
        model.addAttribute("platform", platform);
        model.addAttribute("version", version);
    }

    private void fillProduct(Model model) {
        List<Product> product = productRepo.findAll();
        model.addAttribute("product", product);
    }

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("HOME PAGE");
        List<Product> lstProduct = productRepo.findAll();
        fillProduct(model);
        model.addAttribute("lstProduct", lstProduct);
        return "index";
    }
}
